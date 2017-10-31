package kr.co.e1.workreport.statistics;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface StatisticsPresenter {

  void onCreated(Bundle savedInstanceState);

  boolean onBottomNavigationItemSelected(int itemId);

  interface View {

    final static int POSITION_NAVI_RATIO = 0;
    final static int POSITION_NAVI_GRAPH = 1;
    final static int POSITION_NAVI_TOTAL = 2;

    void showOperationFragment();

    void showGraphFragment();

    void showTotalFragment();

    void setListener();
  }
}
