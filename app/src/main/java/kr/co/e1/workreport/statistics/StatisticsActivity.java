package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.statisticsgraph.GraphFragment;
import kr.co.e1.workreport.statisticsoperation.OperationFragment;
import kr.co.e1.workreport.statisticstotal.TotalFragment;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class StatisticsActivity extends BaseActivity
    implements StatisticsPresenter.View, BottomNavigationView.OnNavigationItemSelectedListener {
  @Inject StatisticsPresenter presenter;
  @BindView(R.id.bottom_navigation_view) BottomNavigationView bottomNavigationView;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_statistics;
  }

  @Override protected int getTitleResId() {
    return R.string.statistics;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    finish();
    return super.onOptionsItemSelected(item);
  }

  @Override public void showOperationFragment() {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_RATIO).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, OperationFragment.newInstance())
        .commit();
  }

  @Override public void showGraphFragment() {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_GRAPH).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, GraphFragment.newInstance())
        .commit();
  }

  @Override public void showTotalFragment() {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_TOTAL).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, TotalFragment.newInstance())
        .commit();
  }

  @Override public void setListener() {
    bottomNavigationView.setOnNavigationItemSelectedListener(this);
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    return presenter.onBottomNavigationItemSelected(item.getItemId());
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return null;
  }
}
