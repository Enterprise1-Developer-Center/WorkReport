package kr.co.e1.workreport.statistics.fm_analytics;

import android.os.Bundle;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class AnalyticsFragment extends BaseFragment {
  @Override protected int getLayoutResID() {
    return R.layout.fragment_analytics;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected boolean isDagger() {
    return false;
  }

  public static AnalyticsFragment newInstance(int year) {
    AnalyticsFragment f = new AnalyticsFragment();
    Bundle args = new Bundle();
    args.putInt("year", year);
    f.setArguments(args);
    return f;
  }
}
