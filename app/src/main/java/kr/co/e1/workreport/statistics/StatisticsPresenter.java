package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import java.util.List;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface StatisticsPresenter {

  void onCreated(Bundle savedInstanceState);

  void onSpinnerItemSelected(String name, int year);

  boolean onBottomNavigationItemSelected(int year, int itemId, boolean checked);

  interface View {

    void setListener();

    void showSpinner(List<String> items);

    void showOperationFragment(int year);

    void showTotalFragment(int year);

    void showAnalyticsFragment(int year);

    void showHolidayFragment(int year);
  }
}
