package kr.co.e1.workreport.statistics;

import android.os.Bundle;
import android.view.MenuItem;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class StatisticsActivity extends BaseActivity {
  @Override protected void onCreated(Bundle savedInstanceState) {

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
    return false;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    onBackPressed();
    return super.onOptionsItemSelected(item);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
  }
}
