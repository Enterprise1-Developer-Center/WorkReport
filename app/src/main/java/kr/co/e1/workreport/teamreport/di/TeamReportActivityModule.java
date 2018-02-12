package kr.co.e1.workreport.teamreport.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import kr.co.e1.workreport.teamreport.TeamReportPresenter;
import kr.co.e1.workreport.teamreport.TeamReportPresenterImpl;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapter;
import kr.co.e1.workreport.teamreport.adapter.TeamReportAdapterView;
import kr.co.e1.workreport.teamreport.dialog.di.TeamReportDialogComponent;
import kr.co.e1.workreport.teamreport.network.TeamReportNetwork;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { TeamReportDialogComponent.class }) public class TeamReportActivityModule {

  @Provides @Singleton TeamReportPresenter provideTeamReportPresenter(TeamReportActivity activity,
      TeamReportAdapter adapter, TeamReportNetwork network) {
    return new TeamReportPresenterImpl(activity, adapter, network);
  }

  @Provides @Singleton TeamReportAdapter provideTeamReportAdapter(
      TeamReportActivity teamReportActivity) {
    return new TeamReportAdapter().setOnRecyclerItemClickListener(teamReportActivity);
  }

  @Provides @Singleton TeamReportAdapterView provideTeamReportAdapterView(
      TeamReportAdapter adapter) {
    return adapter;
  }

  @Provides @Singleton TeamReportNetwork provideTeamReportNetwork() {
    return new TeamReportNetwork(MyApplication.BASE_URL);
  }
}