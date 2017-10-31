package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.graph.GraphFragment;
import kr.co.e1.workreport.operation.OperationFragment;
import kr.co.e1.workreport.total.TotalFragment;
import timber.log.Timber;

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
    onBackPressed();
    return super.onOptionsItemSelected(item);
  }

  @Override public void onBackPressed() {
    //super.onBackPressed();
    Timber.d("stackCount = " + getSupportFragmentManager().getBackStackEntryCount());
  }

  private OperationFragment of = OperationFragment.newInstance();
  private GraphFragment gf = GraphFragment.newInstance();
  private TotalFragment tf = TotalFragment.newInstance();

  @Override public void showOperationFragment() {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_RATIO).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, of)
        .commit();
  }

  @Override public void showGraphFragment() {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_GRAPH).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, gf)
        .commit();
  }

  @Override public void showTotalFragment() {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_TOTAL).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, tf)
        .commit();
  }

  @Override public void setListener() {
    bottomNavigationView.setOnNavigationItemSelectedListener(this);
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    return presenter.onBottomNavigationItemSelected(item.getItemId());
  }
}
