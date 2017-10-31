package kr.co.e1.workreport.teamreport;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class TeamReportActivityModule {

  @Provides TeamReportPresenter.View provideTeamReportView(TeamReportActivity TeamReportActivity) {
    return TeamReportActivity;
  }

  @Provides TeamReportPresenter provideTeamReportPresenter(TeamReportPresenter.View view) {
    return new TeamReportPresenterImpl(view);
  }
}