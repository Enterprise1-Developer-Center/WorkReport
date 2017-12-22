package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
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
    initSpinner();
  }

  private void initSpinner() {

    List<String> items = new ArrayList<>();
    items.add("2017");
    items.add("2018");

    // networking..

    view.showSpinner(items);
  }

  @Override public boolean onBottomNavigationItemSelected(int itemId, boolean isChecked) {
    if (!isChecked) {
      switch (itemId) {
        case R.id.action_ratio:
          view.showOperationFragment();
          break;
        case R.id.action_total:
          view.showTotalFragment();
          break;
      }
    }
    return false;
  }

  @DebugLog @Override public void onSpinnerItemSelected(String item) {

  }
}