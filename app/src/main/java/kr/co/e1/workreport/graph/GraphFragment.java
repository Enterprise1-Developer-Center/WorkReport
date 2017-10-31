package kr.co.e1.workreport.graph;

import android.os.Bundle;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2017. 10. 31..
 */

public class GraphFragment extends BaseFragment {
  public static GraphFragment newInstance() {
    return new GraphFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_graph;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected boolean isDagger() {
    return false;
  }
}
