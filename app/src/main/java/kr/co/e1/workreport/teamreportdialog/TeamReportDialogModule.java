package kr.co.e1.workreport.teamreportdialog;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class TeamReportDialogModule {

  @Provides TeamReportDialogPresenter.View provideTeamReportDialogView(TeamReportDialog dialog) {
    return dialog;
  }

  @Provides TeamReportDialogPresenter provideTeamReportDialogPresenter(
      TeamReportDialogPresenter.View view) {
    return new TeamReportDialogPresenterImpl(view);
  }
}