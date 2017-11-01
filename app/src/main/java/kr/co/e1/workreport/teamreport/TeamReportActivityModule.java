package kr.co.e1.workreport.teamreport;

import dagger.Module;
import dagger.Provides;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreportdialog.TeamReportDialogComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { TeamReportDialogComponent.class}) public class TeamReportActivityModule {

  @DebugLog @Provides TeamReportPresenter.View provideTeamReportView(TeamReportActivity TeamReportActivity) {
    return TeamReportActivity;
  }

  @DebugLog @Provides TeamReportPresenter provideTeamReportPresenter(TeamReportPresenter.View view,
      TeamReportActivity teamReportActivity) {
    return new TeamReportPresenterImpl(view, teamReportActivity.adapter);
  }

  @DebugLog @Provides TeamReportAdapter provideTeamReportAdapter(TeamReportActivity teamReportActivity) {
    return new TeamReportAdapter(teamReportActivity);
  }

  @DebugLog @Provides BaseAdapterView provideTeamReportAdapterView(TeamReportActivity teamReportActivity) {
    return teamReportActivity.adapter;
  }
}