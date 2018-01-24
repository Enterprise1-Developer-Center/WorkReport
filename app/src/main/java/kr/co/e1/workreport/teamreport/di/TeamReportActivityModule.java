package kr.co.e1.workreport.teamreport.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import kr.co.e1.workreport.teamreport.TeamReportPresenter;
import kr.co.e1.workreport.teamreport.TeamReportPresenterImpl;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapterView;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialogComponent;
import kr.co.e1.workreport.teamreport.network.TeamReportNetwork;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { TeamReportDialogComponent.class }) public class TeamReportActivityModule {

  @Provides TeamReportPresenter.View provideTeamReportView(TeamReportActivity TeamReportActivity) {
    return TeamReportActivity;
  }

  @Provides TeamReportPresenter provideTeamReportPresenter(TeamReportPresenter.View view,
      TeamReportActivity teamReportActivity, TeamReportNetwork network) {
    return new TeamReportPresenterImpl(view, teamReportActivity.getAdapter(), network);
  }

  @Provides TeamReportAdapter provideTeamReportAdapter(TeamReportActivity teamReportActivity) {
    return new TeamReportAdapter().setOnRecyclerItemClickListener(teamReportActivity);
  }

  @Provides TeamReportAdapterView provideTeamReportAdapterView(
      TeamReportActivity teamReportActivity) {
    return teamReportActivity.getAdapter();
  }

  @Provides TeamReportNetwork provideTeamReportNetwork() {
    return new TeamReportNetwork(MyApplication.BASE_URL);
  }
}