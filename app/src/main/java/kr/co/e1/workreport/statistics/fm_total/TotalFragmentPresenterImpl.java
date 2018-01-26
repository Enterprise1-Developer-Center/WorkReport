package kr.co.e1.workreport.statistics.fm_total;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_total.network.TotalNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class TotalFragmentPresenterImpl implements TotalFragmentPresenter {

  private View view;
  private TotalNetwork network;
  private TotalChartDataGen chartDataGen;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public TotalFragmentPresenterImpl(View view, TotalNetwork network,
      TotalChartDataGen chartDataGen) {
    this.view = view;
    this.network = network;
    this.chartDataGen = chartDataGen;
  }

  @Override public void onActivityCreate(int year) {
    view.showProgress();

    compositeDisposable.add(network.getSummaryTotal(year)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            chartDataGen.setItems(result.getContent());
            view.showChart(chartDataGen.getBarData(), chartDataGen.getQuarters());
            //view.showTotal(chartDataGen.getTotal());
          } else {
            view.showMessage(result.getMsg());
          }
          view.hideProgress();
        }, throwable -> {

          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}
