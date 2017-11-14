package kr.co.e1.workreport.classificationdialog;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationDialogPresenterImpl implements ClassificationDialogPresenter {

  private ClassificationDialogPresenter.View view;
  private BaseAdapterDataModel<ClassificationCode> adapterDataModel;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private ClassificationNetwork network;

  @Inject ClassificationDialogPresenterImpl(View view,
      BaseAdapterDataModel<ClassificationCode> adapterDataModel, ClassificationNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState, String work) {
    view.setRecyclerView();
    view.showWork(work);
    view.showProgress();
    compositeDisposable.add(network.getCode()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<WResult<List<ClassificationCode>>>() {
          @DebugLog @Override public void accept(WResult<List<ClassificationCode>> result)
              throws Exception {
            if (result.getResult() == NetworkHelper.RESULT_SUCCESS) {
              adapterDataModel.addAll(result.getContent());
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

  @Override
  public void setAdapterDataModel(BaseAdapterDataModel<ClassificationCode> adapterDataModel) {
    this.adapterDataModel = adapterDataModel;
  }
}