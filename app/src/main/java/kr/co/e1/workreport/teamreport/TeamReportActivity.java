package kr.co.e1.workreport.teamreport;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import butterknife.BindView;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreport.vo.TeamReport;
import kr.co.e1.workreport.teamreportdialog.TeamReportDialog;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportActivity extends BaseActivity
    implements TeamReportPresenter.View, OnRecyclerItemClickListener<TeamReport> {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Inject TeamReportAdapter adapter;
  @Inject TeamReportPresenter presenter;
  @Inject BaseAdapterView adapterView;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
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
    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @DebugLog @Override public void onItemClick(TeamReport item) {
    new TeamReportDialog().show(getSupportFragmentManager(),TeamReportDialog.class.getSimpleName());
  }
}
