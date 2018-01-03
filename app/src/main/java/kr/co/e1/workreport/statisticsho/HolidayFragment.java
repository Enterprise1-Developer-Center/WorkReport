package kr.co.e1.workreport.statisticsho;

import android.os.Bundle;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.statisticsan.AnalyticsFragment;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class HolidayFragment extends BaseFragment {
  @Override protected int getLayoutResID() {
    return R.layout.fragment_holiday;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected boolean isDagger() {
    return false;
  }

  public static HolidayFragment newInstance(int year) {
    HolidayFragment f = new HolidayFragment();
    Bundle args = new Bundle();
    args.putInt("year", year);
    f.setArguments(args);
    return f;
  }
}
