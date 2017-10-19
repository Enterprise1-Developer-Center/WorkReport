package kr.co.e1.workreport.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.login.LoginFragment;
import kr.co.e1.workreport.settings.SettingsActivity;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener, MainPresenter.View,
    HasSupportFragmentInjector, LoginCommunicationListener {

  @Inject MainPresenter presenter;
  @BindView(R.id.navigation_view) NavigationView navigationView;
  @BindView(R.id.fragment_container) ViewGroup fragmentContainer;

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

  @Override public void openLoginFragment(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.fragment_container, LoginFragment.newInstance(null))
          .addToBackStack(null)
          .commit();
    }
  }

  @Override public void closeLoginFragment() {
    getSupportFragmentManager().popBackStack();
  }

  @Override public void navigateToSettings() {
    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
    startActivity(intent);
  }

  @DebugLog @Override public void changeTheme() {
    setTheme(R.style.AppTheme_NoActionBar);
  }

  @OnClick({
      R.id.date_rootview, R.id.group_rootview, R.id.person_rootview, R.id.start_time_rootview,
      R.id.end_time_rootview, R.id.code_rootview, R.id.project_rootview, R.id.last_edit_rootview
  }) void onClick(View view) {
    if (view.getId() == R.id.date_rootview) {
    } else if (view.getId() == R.id.group_rootview) {
    } else if (view.getId() == R.id.person_rootview) {
    }
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      if (getSupportFragmentManager().getBackStackEntryCount() == 0) super.onBackPressed();
    }
  }

  @Override public boolean onNavigationItemSelected(MenuItem item) {
    presenter.onNavigationItemSelected(item.getItemId());
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }

  @Override public void startMain() {
    presenter.startMain();
  }
}