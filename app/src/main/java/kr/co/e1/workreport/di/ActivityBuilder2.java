package kr.co.e1.workreport.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import kr.co.e1.workreport.teamreport.di.TeamReportActivityModule;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialogModule;

/**
 * Created by jaeho on 2018. 2. 9
 */

@Module public abstract class ActivityBuilder2 {
  @ContributesAndroidInjector(modules = {
      TeamReportActivityModule.class, TeamReportDialogModule.class
  }) abstract TeamReportActivity bindTeamReportActivity();
}