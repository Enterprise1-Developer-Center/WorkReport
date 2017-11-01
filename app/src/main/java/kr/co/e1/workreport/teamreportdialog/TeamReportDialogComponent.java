package kr.co.e1.workreport.teamreportdialog;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Subcomponent(modules = TeamReportDialogModule.class) public interface TeamReportDialogComponent
    extends AndroidInjector<TeamReportDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<TeamReportDialog> {

  }
}