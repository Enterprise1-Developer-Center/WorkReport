package kr.co.e1.workreport.projmanage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class ProjManageActivity extends BaseActivity {
  @BindView(R.id.viewpager) ViewPager viewPager;
  @BindView(R.id.tabs) TabLayout tabLayout;
  @Inject ProjManageAdapter adapter;

  @Override protected void onCreated(Bundle savedInstanceState) {
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
    tabLayout.getTabAt(ProjMPos.PROJ.getValue()).setText(R.string.project_list);
    tabLayout.getTabAt(ProjMPos.EMPL.getValue()).setText(R.string.employee_list);
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

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}
