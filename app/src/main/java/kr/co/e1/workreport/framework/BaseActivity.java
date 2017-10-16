package kr.co.e1.workreport.framework;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 9. 25
 */

public abstract class BaseActivity extends AppCompatActivity {

  private Unbinder unbinder;
  protected @BindView(R.id.toolbar) Toolbar toolbar;
  protected @BindView(R.id.drawer_layout) DrawerLayout drawer;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
    setContentView(getLayoutResID());
    unbinder = ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    setNavigationBarColor();
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

  protected abstract int getLayoutResID();
}
