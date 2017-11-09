package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailActivity extends BaseActivity {
  @Override protected void onCreated(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResID() {
    return 0;
  }

  @Override protected int getTitleResId() {
    return 0;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return false;
  }

  @Override protected boolean isDagger() {
    return false;
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return null;
  }
}
