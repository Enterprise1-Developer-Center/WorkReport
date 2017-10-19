package kr.co.e1.workreport.report;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class ReportFragment extends BaseFragment {
  @Override protected int getLayoutResID() {
    return R.layout.fragment_report;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  public static Fragment newInstance(Bundle args) {
    ReportFragment f = new ReportFragment();
    f.setArguments(args);
    return f;
  }
}
