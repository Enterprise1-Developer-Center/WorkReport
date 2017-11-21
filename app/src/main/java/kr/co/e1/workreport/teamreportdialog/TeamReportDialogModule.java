package kr.co.e1.workreport.teamreportdialog;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.common.adapter.ReportAdapterView;
import kr.co.e1.workreport.teamreportdialog.adapter.TeamReportAdapter;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class TeamReportDialogModule {

  @Provides TeamReportDialogPresenter.View provideTeamReportDialogView(TeamReportDialog dialog) {
    return dialog;
  }

  @Provides TeamReportDialogPresenter provideTeamReportDialogPresenter(
      TeamReportDialogPresenter.View view, TeamReportDialog dialog,
      TeamReportDialogNetwork network) {
    return new TeamReportDialogPresenterImpl(view, dialog.adapter, network, dialog.getUserId());
  }

  @Provides ReportAdapterView provideReportAdapterView(TeamReportDialog dialog) {
    return dialog.adapter;
  }

  @Provides TeamReportAdapter provideTeamReportAdapter(TeamReportDialog dialog) {
    return new TeamReportAdapter(dialog);
  }

  @Provides TeamReportDialogNetwork provideTeamReportDialogNetwork() {
    return new TeamReportDialogNetwork(Constants.BASE_URL);
  }
}