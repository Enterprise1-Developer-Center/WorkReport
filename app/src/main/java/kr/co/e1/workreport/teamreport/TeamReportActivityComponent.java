package kr.co.e1.workreport.teamreport;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialogProvider;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = { TeamReportActivityModule.class, TeamReportDialogProvider.class })
public interface TeamReportActivityComponent extends AndroidInjector<TeamReportActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<TeamReportActivity> {

  }
}
