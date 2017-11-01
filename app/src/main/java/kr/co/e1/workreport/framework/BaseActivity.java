package kr.co.e1.workreport.framework;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.support.HasSupportFragmentInjector;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 9. 25
 */

public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {

  private Unbinder unbinder;
  protected @BindView(R.id.toolbar) Toolbar toolbar;
  protected @BindView(R.id.drawer_layout) DrawerLayout drawer;
  protected @BindView(R.id.app_bar_layout) AppBarLayout appBar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (isDagger()) AndroidInjection.inject(this);
    setContentView(getLayoutResID());
    unbinder = ButterKnife.bind(this);
    toolbar.setTitle(getTitleResId());
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(isDisplayHomeAsUpEnabled());
    setNavigationBarColor();
    onCreated(savedInstanceState);
  }

  private void setNavigationBarColor() {
    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }

  protected abstract void onCreated(Bundle savedInstanceState);

  protected abstract int getLayoutResID();

  protected abstract @StringRes int getTitleResId();

  protected abstract boolean isDisplayHomeAsUpEnabled();

  protected abstract boolean isDagger();
}
