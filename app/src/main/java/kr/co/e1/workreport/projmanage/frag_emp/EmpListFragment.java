package kr.co.e1.workreport.projmanage.frag_emp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import butterknife.BindView;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.projmanage.frag_emp.adapter.EmpListAdapter;
import kr.co.e1.workreport.projmanage.frag_emp.adapter.EmpListAdapterView;
import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;
import kr.co.e1.workreport.projmanage.listener.OnFabClickListener;
import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class EmpListFragment extends BaseFragment
    implements EmpListFragmentPresenter.View, OnFabClickListener,
    OnRecyclerItemClickListener<Employee> {

  @BindView(R.id.recyclerview) RecyclerView recyclerview;
  @BindView(R.id.root_view) FrameLayout rootView;
  @Inject @Getter EmpListAdapter adapter;
  @Inject EmpListAdapterView adapterView;
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
    presenter.onActivityCreate();
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @DebugLog @Override public void onFabClick() {

  }

  @Override public void setRecyclerView() {
    LinearLayoutManager layout = new LinearLayoutManager(getContext());
    recyclerview.setLayoutManager(layout);
    recyclerview.setAdapter(adapter);
    recyclerview.setItemAnimator(new SlideInDownAnimator());
    recyclerview.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
    recyclerview.getItemAnimator().setRemoveDuration(Constants.ANI_DURATION);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void removeRefresh() {
    adapterView.refreshRemove();
  }

  @Override public void onItemClick(Employee item) {

  }
}
