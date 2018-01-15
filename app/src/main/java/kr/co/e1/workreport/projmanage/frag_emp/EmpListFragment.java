package kr.co.e1.workreport.projmanage.frag_emp;

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

public class EmpListFragment extends BaseFragment implements EmpListFragmentPresenter.View,
    OnAddClickListener {

  @Inject EmpListFragmentPresenter presenter;

  public static EmpListFragment newInstance() {
    Bundle args = new Bundle();
    EmpListFragment fragment = new EmpListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_proj_manage_emp_list;
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
