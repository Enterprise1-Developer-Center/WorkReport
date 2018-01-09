package kr.co.e1.workreport.statistics.fm_operatio;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class OperationFragmentPresenterImpl implements OperationFragmentPresenter {

  private View view;
  private OpRatioNetwork network;
  private ChartDataGen chartDataGen;

  OperationFragmentPresenterImpl(View view, OpRatioNetwork network, ChartDataGen chartDataGen) {
    this.view = view;
    this.network = network;
    this.chartDataGen = chartDataGen;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private Disposable disposable;

  @Override public void onActivityCreate(int year) {
    view.showProgress();
    view.detailButtonEnabled(false);
    compositeDisposable.add(network.getOperRatio(year)
        .subscribeOn(Schedulers.io())
        .delay(NetworkHelper.DELAY, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          chartDataGen.setOpRatioContent(result.getContent());
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            view.showNowOpRatioChart(chartDataGen.getNowOpRatioChartData(),
                chartDataGen.getNowOpRatio(), chartDataGen.getNowOpRatioQuarters());
            view.detailButtonEnabled(true);
          } else {
            view.showMessage(result.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        }));

    disposable = network.getYearOperationRatio(year)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            chartDataGen.setYearOperationRatios(result.getContent());
            view.showYearOpRatioChart(chartDataGen.getYearOperationRatioData(),
                chartDataGen.getTot_rate(), chartDataGen.getYearOperationRatioQuarters());
          } else {
            view.showMessage(result.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        });
  }

  @Override public void onClick(int id) {
    if (id == R.id.detail_button) view.navigateToOpDetail();
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
    if (disposable != null) {
      disposable.dispose();
    }
  }
}
