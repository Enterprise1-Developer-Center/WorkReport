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

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportActivity extends BaseActivity
    implements TeamReportPresenter.View, OnRecyclerItemClickListener<TeamReport> {

  @Inject TeamReportPresenter presenter;

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

  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @Inject TeamReportAdapter adapter;
  private BaseAdapterView adapterView;

  @Override public void setRecyclerView() {
    adapterView = adapter;
    presenter.setAdapterDataModel(adapter);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @DebugLog @Override public void onItemClick(TeamReport item) {

  }
}
