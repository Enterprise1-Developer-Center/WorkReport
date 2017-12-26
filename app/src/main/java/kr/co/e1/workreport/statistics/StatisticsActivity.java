package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.ObjectUtils;
import kr.co.e1.workreport.framework.abs.OnSimpleItemSelectedListener;
import kr.co.e1.workreport.statisticsop.OperationFragment;
import kr.co.e1.workreport.statisticstotal.TotalFragment;

import static kr.co.e1.workreport.statistics.StatisticsPresenter.POSITION_NAVI_RATIO;
import static kr.co.e1.workreport.statistics.StatisticsPresenter.POSITION_NAVI_TOTAL;

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
    finish();
    return super.onOptionsItemSelected(item);
  }

  @Override public void showOperationFragment(String year) {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_RATIO).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, OperationFragment.newInstance())
        .commit();
  }

  @Override public void showTotalFragment(String year) {
    bottomNavigationView.getMenu().getItem(POSITION_NAVI_TOTAL).setChecked(true);
    getSupportFragmentManager().beginTransaction()
        .setCustomAnimations(R.animator.enter_animation, R.animator.exit_animation,
            R.animator.enter_animation, R.animator.exit_animation)
        .replace(R.id.fragment_container, TotalFragment.newInstance())
        .commit();
  }

  @Override public void showSpinner(List<String> items) {
    spinner.setVisibility(View.VISIBLE);
    adapter.addAll(items);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new OnSimpleItemSelectedListener() {
      @Override public void onItemSelected(int position, long id) {
        presenter.onSpinnerItemSelected(getNowFragmentName(), adapter.getItem(position));
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
    String year = String.valueOf(spinner.getSelectedItem());
    return presenter.onBottomNavigationItemSelected(year, item.getItemId(), item.isChecked());
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}
