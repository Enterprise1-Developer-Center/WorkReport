package kr.co.e1.workreport.teamreport.dialog.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialog;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialogPresenter;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialogPresenterImpl;
import kr.co.e1.workreport.teamreport.dialog.adapter.TeamDialogAdapterView;
import kr.co.e1.workreport.teamreport.dialog.adapter.TeamReportDialogAdapter;
import kr.co.e1.workreport.teamreport.dialog.network.TeamReportDialogNetwork;

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
    return new TeamReportDialogPresenterImpl(view, dialog.getAdapter(), network, dialog.getUserId());
  }

  @Provides TeamDialogAdapterView provideReportAdapterView(TeamReportDialog dialog) {
    return dialog.getAdapter();
  }

  @Provides TeamReportDialogAdapter provideTeamReportAdapter(TeamReportDialog dialog) {
    return new TeamReportDialogAdapter(dialog);
  }

  @Provides TeamReportDialogNetwork provideTeamReportDialogNetwork() {
    return new TeamReportDialogNetwork(MyApplication.BASE_URL);
  }
}