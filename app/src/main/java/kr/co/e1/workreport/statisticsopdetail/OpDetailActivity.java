package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.statisticsopdetail.adapter.OpDetailAdapter;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailActivity extends BaseActivity implements OpDetailPresenter.View {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Inject OpDetailAdapter adapter;
  @Inject OpDetailPresenter presenter;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
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
    return true;
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return null;
  }



  @Override public void setRecyclerView() {
    LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapter.refresh();
  }
}
