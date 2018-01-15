package kr.co.e1.workreport.projmanage.frag_proj;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.projmanage.listener.OnAddClickListener;
import timber.log.Timber;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class ProjListFragment extends BaseFragment implements ProjListFragmentPresenter.View,
    OnAddClickListener {
  @Inject ProjListFragmentPresenter presenter;

  public static ProjListFragment newInstance() {
    Bundle args = new Bundle();
    ProjListFragment fragment = new ProjListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_proj_manage_proj_list;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @DebugLog @Override public void onAddClick() {

  }
}
