package kr.co.e1.workreport.teamreport;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapterView;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialogComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { TeamReportDialogComponent.class }) public class TeamReportActivityModule {

  @Provides TeamReportPresenter.View provideTeamReportView(TeamReportActivity TeamReportActivity) {
    return TeamReportActivity;
  }

  @Provides TeamReportPresenter provideTeamReportPresenter(TeamReportPresenter.View view,
      TeamReportActivity teamReportActivity, TeamReportNetwork network) {
    return new TeamReportPresenterImpl(view, teamReportActivity.adapter, network);
  }

  @Provides TeamReportAdapter provideTeamReportAdapter(TeamReportActivity teamReportActivity) {
    return new TeamReportAdapter().setOnRecyclerItemClickListener(teamReportActivity);
  }

  @Provides TeamReportAdapterView provideTeamReportAdapterView(
      TeamReportActivity teamReportActivity) {
    return teamReportActivity.adapter;
  }

  @Provides TeamReportNetwork provideTeamReportNetwork() {
    return new TeamReportNetwork(Constants.BASE_URL);
  }
}