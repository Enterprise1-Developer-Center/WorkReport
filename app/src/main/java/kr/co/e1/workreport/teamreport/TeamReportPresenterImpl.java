package kr.co.e1.workreport.teamreport;

import android.os.Bundle;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.teamreport.vo.TeamReport;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportPresenterImpl implements TeamReportPresenter {
  private TeamReportPresenter.View view;
  private BaseAdapterDataModel<TeamReport> adapterDataModel;

  TeamReportPresenterImpl(TeamReportPresenter.View view,
      BaseAdapterDataModel<TeamReport> adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onCreated(Bundle savedInstanceState) {
    view.setRecyclerView();
    adapterDataModel.add(new TeamReport("홍승연", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("최정훈", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("이완섭", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("문재선", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("이미자", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("신명재", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("민병일", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("손성", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("오재호", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("박동선", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("구서현", "프로젝트 정보 요약"));
    adapterDataModel.add(new TeamReport("장현희", "프로젝트 정보 요약"));
    view.refresh();
  }
}