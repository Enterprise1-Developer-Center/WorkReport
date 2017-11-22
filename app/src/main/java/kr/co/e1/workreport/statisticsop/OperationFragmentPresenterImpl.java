package kr.co.e1.workreport.statisticsop;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class OperationFragmentPresenterImpl implements OperationFragmentPresenter {

  private View view;
  private OpRatioNetwork network;

  OperationFragmentPresenterImpl(View view, OpRatioNetwork network) {
    this.view = view;
    this.network = network;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.showProgress();
    view.detailButtonEnabled(false);
    compositeDisposable.add(network.getOperRatio()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            view.showYearOpRatioChart();
            view.showMemberOpRatioChart();
            view.detailButtonEnabled(true);
          } else {
            view.showMessage(R.string.error_server_error);
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        }));
  }

  @Override public void onClick(int id) {
    if (id == R.id.detail_button) view.navigateToOpDetail();
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}
