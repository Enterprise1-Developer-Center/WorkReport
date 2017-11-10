package kr.co.e1.workreport.teamreport;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapterView;
import kr.co.e1.workreport.teamreportdialog.TeamReportDialogComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { TeamReportDialogComponent.class }) public class TeamReportActivityModule {

  @Provides TeamReportPresenter.View provideTeamReportView(TeamReportActivity TeamReportActivity) {
    return TeamReportActivity;
  }

  @Provides TeamReportPresenter provideTeamReportPresenter(TeamReportPresenter.View view,
      TeamReportActivity teamReportActivity) {
    return new TeamReportPresenterImpl(view, teamReportActivity.adapter);
  }

  @Provides TeamReportAdapter provideTeamReportAdapter(TeamReportActivity teamReportActivity) {
    return new TeamReportAdapter(teamReportActivity);
  }

  @Provides TeamReportAdapterView provideTeamReportAdapterView(TeamReportActivity teamReportActivity) {
    return teamReportActivity.adapter;
  }
}