package kr.co.e1.workreport.projmanage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.interfaces.OnSimpleTabSelectedListener;
import kr.co.e1.workreport.framework.utils.ObjectUtils;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class ProjManageActivity extends BaseActivity implements ProjManagePresenter.View {
  @BindView(R.id.tabs) TabLayout tabLayout;
  @Inject ProjManagePresenter presenter;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated();
  }

  @Override public void setTabLayout() {
    tabLayout.addTab(
        tabLayout.newTab().setIcon(R.drawable.ic_whatshot).setText(R.string.project_list));
    tabLayout.addTab(
        tabLayout.newTab().setIcon(R.drawable.ic_group).setText(R.string.employee_list));
    tabLayout.addOnTabSelectedListener(new OnSimpleTabSelectedListener() {
      @Override public void onTabSelected(TabLayout.Tab tab) {
        presenter.onTabSelected(tab.getPosition());
      }
    });
  }

  @Override public void showProjListFragment() {
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, ProjListFragment.newInstance())
        .commit();
  }

  @Override public void showEmpListFragment() {
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, EmpListFragment.newInstance())
        .commit();
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_proj_manage;
  }

  @Override protected int getTitleResId() {
    return R.string.proj_manage;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    finish();
    return true;
  }

  @OnClick(R.id.fab) void onFabClick() {
    Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    if (!ObjectUtils.isEmpty(f)) presenter.onFabClick(f);
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}