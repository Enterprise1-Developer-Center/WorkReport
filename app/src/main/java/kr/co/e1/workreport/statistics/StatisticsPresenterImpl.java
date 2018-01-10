package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import android.text.TextUtils;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.statistics.network.StatisticsNetwork;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class StatisticsPresenterImpl implements StatisticsPresenter {

  private StatisticsPresenter.View view;
  private StatisticsNetwork network;
  private Disposable disposable;

  StatisticsPresenterImpl(StatisticsPresenter.View view, StatisticsNetwork network) {
    this.view = view;
    this.network = network;
  }

  @Override public void onCreated(Bundle savedInstanceState) {
    view.setListener();
    initSpinner();
  }

  private void initSpinner() {
    disposable = network.getAvailableStatisticsYear()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getContent().size() > 0) {
            view.showSpinner(result.getContent());
          }
        });
  }

  @Override public boolean onBottomNavigationItemSelected(int year, int itemId, boolean isChecked) {
    if (!isChecked) {
      switch (itemId) {
        case R.id.action_ratio:
          view.showOperationFragment(year);
          break;
        case R.id.action_total:
          view.showTotalFragment(year);
          break;
        case R.id.action_analytics:
          view.showAnalyticsFragment(year);
          break;
        case R.id.action_holiday:
          view.showHolidayFragment(year);
          break;
      }
    }
    return false;
  }

  @Override public boolean onOptionsItemSelected(int itemId) {
    switch (itemId) {
      case android.R.id.home:
        view.finish();
        break;
      case R.id.action_create_year_db:
        view.showCreateYearDbDialog();
        break;
    }
    return true;
  }

  @DebugLog @Override public void onSpinnerItemSelected(String name, int year) {
    if (!TextUtils.isEmpty(name)) {
      if (name.equals("OperationFragment")) {
        view.showOperationFragment(year);
      } else {
        view.showTotalFragment(year);
      }
    } else {
      view.showOperationFragment(year);
    }
  }
}