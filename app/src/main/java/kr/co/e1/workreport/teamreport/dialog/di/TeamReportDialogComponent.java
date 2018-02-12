package kr.co.e1.workreport.teamreport.dialog.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialog;

/**
 * Created by jaeho on 2018. 2. 12
 */

@Subcomponent(modules = TeamReportDialogModule.class) public interface TeamReportDialogComponent
    extends AndroidInjector<TeamReportDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<TeamReportDialog> {

  }
}
