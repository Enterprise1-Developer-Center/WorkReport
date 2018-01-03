package kr.co.e1.workreport.main.dialog_class;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.main.dialog_class.adapter.ClassAdapterDataModel;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationDialogPresenterImpl implements ClassificationDialogPresenter {

  private ClassificationDialogPresenter.View view;
  private ClassAdapterDataModel adapterDataModel;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private ClassificationNetwork network;

  @Inject ClassificationDialogPresenterImpl(View view,
      ClassAdapterDataModel adapterDataModel, ClassificationNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
  }

  @DebugLog @Override public void onActivityCreate(Bundle savedInstanceState, DetailWork nowDetailWork) {
    view.setRecyclerView();
    view.showProgress();
    compositeDisposable.add(network.getCode()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<WResult<List<DetailWork>>>() {
          @DebugLog @Override public void accept(WResult<List<DetailWork>> result)
              throws Exception {
            if (result.getResult() == WResult.RESULT_SUCCESS) {
              adapterDataModel.addAll(result.getContent());
              view.showWork(nowDetailWork.getDetail());
              view.refresh();
            } else {
              view.showMessage(R.string.error_server_error);
            }
            view.hideProgress();
          }
        }, new Consumer<Throwable>() {
          @DebugLog @Override public void accept(Throwable throwable) throws Exception {
            view.showMessage(R.string.error_server_error);
            view.hideProgress();
          }
        }));
  }

  @Override public void onPositiveClick(String work) {
    view.dismiss(adapterDataModel.getSelectedItem().setDetail(work));
  }
}