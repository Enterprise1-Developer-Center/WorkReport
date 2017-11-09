package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailActivity extends BaseActivity {
  @Override protected void onCreated(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_statistics_op_detail;
  }

  @Override protected int getTitleResId() {
    return R.string.operation_ration_table;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    finish();
    return super.onOptionsItemSelected(item);
  }

  @Override protected boolean isDagger() {
    return false;
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return null;
  }
}
