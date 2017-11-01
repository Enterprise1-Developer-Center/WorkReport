package kr.co.e1.workreport.statisticsoperation;

import android.os.Bundle;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class OperationFragment extends BaseFragment {
  public static OperationFragment newInstance() {
    return new OperationFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_operation_ratio;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
  }

  @Override protected boolean isDagger() {
    return false;
  }
}