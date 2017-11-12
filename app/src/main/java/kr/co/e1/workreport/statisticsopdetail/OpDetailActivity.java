package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.statisticsopdetail.adapter.OpDetailAdapter;
import kr.co.e1.workreport.statisticsopdetail.adapter.OpDetailAdapterView;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailActivity extends BaseActivity implements OpDetailPresenter.View {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @BindView(R.id.progress_bar) ProgressBar progressBar;

  @Inject OpDetailAdapter adapter;
  @Inject OpDetailAdapterView adapterView;
  @Inject OpDetailPresenter presenter;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
    setLayoutScrollFlag(true);
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
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
  }

  @Override public void refresh() {
  }

  @Override public void refresh(int position) {
    adapterView.refresh(position);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }
}
