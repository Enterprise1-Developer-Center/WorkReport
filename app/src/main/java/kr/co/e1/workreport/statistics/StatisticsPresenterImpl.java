package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class StatisticsPresenterImpl implements StatisticsPresenter {

  private StatisticsPresenter.View view;

  StatisticsPresenterImpl(StatisticsPresenter.View view) {
    this.view = view;
  }

  @Override public void onCreated(Bundle savedInstanceState) {
    view.setListener();
    view.showOperationFragment();
    //view.showGraphFragment();
    //view.showTotalFragment();
  }

  @Override public boolean onBottomNavigationItemSelected(int itemId) {
    switch (itemId) {
      case R.id.action_ratio:
        view.showOperationFragment();
        break;
      case R.id.action_total:
        view.showTotalFragment();
        break;
    }

    return false;
  }
}