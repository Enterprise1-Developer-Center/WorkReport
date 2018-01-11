package kr.co.e1.workreport.statistics.fm_operation;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_operation.network.OperationNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class OperationFragmentPresenterImpl implements OperationFragmentPresenter {

  private View view;
  private OperationNetwork network;
  private ChartDataGen chartDataGen;

  OperationFragmentPresenterImpl(View view, OperationNetwork network, ChartDataGen chartDataGen) {
    this.view = view;
    this.network = network;
    this.chartDataGen = chartDataGen;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onActivityCreate(int year) {
    view.showProgress();
    view.detailButtonEnabled(false);

    compositeDisposable.add(network.getYearOperationRate(year)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            chartDataGen.setYearOperationRates(result.getContent());
            view.showYearOpRatioChart(chartDataGen.getYearOperationRateData(),
                chartDataGen.getYear_tot_rate(), chartDataGen.getYearOperationRateQuarters());
          } else {
            view.showMessage(result.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        }));

    compositeDisposable.add(network.getCurrentOperationRate(year)
        .subscribeOn(Schedulers.io())
        .delay(NetworkHelper.DELAY, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          chartDataGen.setCurrOperationRates(result.getContent());
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            view.showNowOpRatioChart(chartDataGen.getCurrOperationRateData(),
                chartDataGen.getCurrTotRate(), chartDataGen.getCurrOperationRateQuarters());
            view.detailButtonEnabled(true);
          } else {
            view.showMessage(result.getMsg());
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
