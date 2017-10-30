package kr.co.e1.workreport.settings;

import android.os.Bundle;
import android.view.MenuItem;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class SettingsActivity extends BaseActivity implements SettingsPresenter.View {

  @Inject SettingsPresenter presenter;
  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_settings;
  }

  @Override protected int getTitleResId() {
    return R.string.settings;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    onBackPressed();
    return true;
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
  }
}