package kr.co.e1.workreport.teamreport.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import javax.inject.Singleton;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import kr.co.e1.workreport.teamreport.dialog.di.TeamReportDialogProvider;

/**
 * Created by jaeho on 2018. 2. 12..
 */

@Singleton @Subcomponent(modules = { TeamReportActivityModule.class, TeamReportDialogProvider.class })
public interface TeamReportActivityComponent extends AndroidInjector<TeamReportActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<TeamReportActivity> {

  }
}
