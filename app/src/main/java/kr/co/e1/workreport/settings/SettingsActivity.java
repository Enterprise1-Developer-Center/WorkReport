package kr.co.e1.workreport.settings;

import android.os.Bundle;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class SettingsActivity extends BaseActivity {
  @Override protected void onCreated(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_settings;
  }

  @Override protected int getTitleResId() {
    return 0;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return false;
  }
}