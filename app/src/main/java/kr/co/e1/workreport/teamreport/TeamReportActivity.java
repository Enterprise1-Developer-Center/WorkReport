package kr.co.e1.workreport.teamreport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapterView;
import kr.co.e1.workreport.teamreport.model.TeamReportContent;
import kr.co.e1.workreport.teamreportdialog.TeamReportDialog;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportActivity extends BaseActivity
    implements TeamReportPresenter.View, OnRecyclerItemClickListener<TeamReportContent> {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @BindView(R.id.progress_bar) ProgressBar progressBar;

  @Inject TeamReportAdapter adapter;
  @Inject TeamReportAdapterView adapterView;
  @Inject TeamReportPresenter presenter;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
    setLayoutScrollFlag(true);
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_team_report;
  }

  @Override protected int getTitleResId() {
    return R.string.team_members;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    finish();
    return super.onOptionsItemSelected(item);
  }

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @DebugLog @Override public void onItemClick(TeamReportContent item) {
    new TeamReportDialog().show(getSupportFragmentManager(),
        TeamReportDialog.class.getSimpleName());
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }
}
