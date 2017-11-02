package kr.co.e1.workreport.statisticsgraph;

import android.os.Bundle;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class GraphFragment extends BaseFragment implements GraphFragmentPresenter.View {

  @Inject GraphFragmentPresenter presenter;

  public static GraphFragment newInstance() {
    return new GraphFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_graph;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);
  }

  @Override protected boolean isDagger() {
    return true;
  }
}
