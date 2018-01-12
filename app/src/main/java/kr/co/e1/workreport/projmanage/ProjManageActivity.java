package kr.co.e1.workreport.projmanage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class ProjManageActivity extends BaseActivity {
  @Override protected void onCreated(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_proj_manage;
  }

  @Override protected int getTitleResId() {
    return R.string.proj_manage;
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
