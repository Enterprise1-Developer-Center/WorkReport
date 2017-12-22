package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import java.util.List;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface StatisticsPresenter {

  public final static int POSITION_NAVI_RATIO = 0;
  public final static int POSITION_NAVI_TOTAL = 1;


  void onCreated(Bundle savedInstanceState);

  boolean onBottomNavigationItemSelected(int itemId, boolean checked);

  void onSpinnerItemSelected(int position, long id);

  interface View {

    void showOperationFragment();

    void showTotalFragment();

    void setListener();

    void showSpinner(List<String> items);
  }
}
