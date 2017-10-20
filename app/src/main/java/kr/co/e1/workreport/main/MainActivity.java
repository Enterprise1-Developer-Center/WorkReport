package kr.co.e1.workreport.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.login.LoginFragment;
import kr.co.e1.workreport.report.ReportFragment;
import kr.co.e1.workreport.settings.SettingsActivity;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener, MainPresenter.View,
    HasSupportFragmentInjector, LoginCommunicationListener {

  @Inject MainPresenter presenter;
  @BindView(R.id.navigation_view) NavigationView navigationView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter.onCreate(savedInstanceState);
  }

  @Override public void setListener() {
    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override public void showLoginFragment(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
              R.animator.enter_animation, R.animator.exit_animation)
          .replace(R.id.fragment_login_container, LoginFragment.newInstance(null))
          .addToBackStack(LoginFragment.class.getSimpleName())
          .commit();
    }
  }
  
  @Override public void navigateToSettings() {
    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
    startActivity(intent);
  }

  @Override public void changeTheme() {
    setTheme(R.style.AppTheme_NoActionBar);
  }

  @Override public void showReportFragment() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragment_report_container, ReportFragment.newInstance(null))
        .addToBackStack(ReportFragment.class.getSimpleName())
        .commit();
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override public void onBackPressed() {
    int stackCount = getSupportFragmentManager().getBackStackEntryCount();
    if (stackCount > 0) {
      presenter.onBackPressed(drawer.isDrawerOpen(GravityCompat.START),
          getSupportFragmentManager().getBackStackEntryAt(stackCount - 1).getName());
    }
  }

  @Override public void closeDrawer() {
    drawer.closeDrawer(GravityCompat.START);
  }

  @DebugLog @Override public void popBackStack(String name) {
    getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
  }

  @Override public boolean onNavigationItemSelected(MenuItem item) {
    presenter.onNavigationItemSelected(item.getItemId());
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override public void loginComplete() {
    presenter.loginComplete();
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}