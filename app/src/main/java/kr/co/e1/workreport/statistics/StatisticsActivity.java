package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import hugo.weaving.DebugLog;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.ObjectUtils;
import kr.co.e1.workreport.framework.abs.OnSimpleItemSelectedListener;
import kr.co.e1.workreport.statistics.analytics.AnalyticsFragment;
import kr.co.e1.workreport.statistics.holiday.HolidayFragment;
import kr.co.e1.workreport.statistics.operatio.OperationFragment;
import kr.co.e1.workreport.statistics.total.TotalFragment;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class StatisticsActivity extends BaseActivity
    implements StatisticsPresenter.View, BottomNavigationView.OnNavigationItemSelectedListener {
  @Inject ArrayAdapter<String> adapter;
  @Inject StatisticsPresenter presenter;
  @BindView(R.id.bottom_navigation_view) BottomNavigationView bottomNavigationView;
  @BindView(R.id.spinner) Spinner spinner;

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
    return presenter.onOptionsItemSelected(item.getItemId());
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.toolbar, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override public void showOperationFragment(int year) {
    bottomNavigationView.getMenu().getItem(BottomNav.RATIO.getValue()).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, OperationFragment.newInstance(year))
        .commit();
  }

  @Override public void showTotalFragment(int year) {
    bottomNavigationView.getMenu().getItem(BottomNav.TOTAL.getValue()).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, TotalFragment.newInstance(year))
        .commit();
  }

  @Override public void showAnalyticsFragment(int year) {
    bottomNavigationView.getMenu().getItem(BottomNav.ANALY.getValue()).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, AnalyticsFragment.newInstance(year))
        .commit();
  }

  @Override public void showHolidayFragment(int year) {
    bottomNavigationView.getMenu().getItem(BottomNav.HOLID.getValue()).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, HolidayFragment.newInstance(year))
        .commit();
  }

  @DebugLog @Override public void showCreateYearDbDialog() {

  }

  @Override public void showSpinner(List<String> items) {
    spinner.setVisibility(View.VISIBLE);
    adapter.addAll(items);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new OnSimpleItemSelectedListener() {
      @Override public void onItemSelected(int position, long id) {
        presenter.onSpinnerItemSelected(getNowFragmentName(),
            Integer.parseInt(adapter.getItem(position)));
      }
    });

    spinner.setSelection(items.indexOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
  }

  private String getNowFragmentName() {
    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    if (!ObjectUtils.isEmpty(fragment)) {
      return fragment.getClass().getSimpleName();
    } else {
      return null;
    }
  }

  @Override public void setListener() {
    bottomNavigationView.setOnNavigationItemSelectedListener(this);
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int year = Integer.parseInt(spinner.getSelectedItem().toString());
    return presenter.onBottomNavigationItemSelected(year, item.getItemId(), item.isChecked());
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}
