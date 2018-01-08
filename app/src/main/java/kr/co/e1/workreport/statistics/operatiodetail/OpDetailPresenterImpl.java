package kr.co.e1.workreport.statistics.operatiodetail;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_operatio.OpRatioNetwork;
import kr.co.e1.workreport.statistics.fm_operatio.model.OpRatioItem;
import kr.co.e1.workreport.statistics.operatiodetail.adapter.OpDetailAdapterDataModel;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class OpDetailPresenterImpl implements OpDetailPresenter {

  private View view;
  private OpDetailAdapterDataModel<OpRatioItem> adapterDataModel;
  private OpRatioNetwork network;

  OpDetailPresenterImpl(View view, OpDetailAdapterDataModel adapterDataModel,
      OpRatioNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onCreated(Bundle savedInstanceState) {
    view.setRecyclerView();
    view.showProgress();
    compositeDisposable.add(network.getOperRatio()
        .delay(Constants.DELAY, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            adapterDataModel.addAll(result.getContent().getOpRatios());
            adapterDataModel.addFooter(result.getContent().getOpRatioTotal());
            view.refresh();
          } else {
            view.showMessage(result.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.hideProgress();
          view.showMessage(R.string.error_server_error);
        }));
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}