package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {
  @Inject TotalFragmentPresenter presenter;

  public static TotalFragment newInstance() {
    return new TotalFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_total;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);
  }

  @Override protected boolean isDagger() {
    return true;
  }
}
