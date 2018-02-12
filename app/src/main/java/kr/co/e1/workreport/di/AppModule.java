package kr.co.e1.workreport.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.main.di.MainActivityComponent;
import kr.co.e1.workreport.projmanage.di.ProjManageActivityComponent;
import kr.co.e1.workreport.statistics.ac_detail.di.OpDetailActivityComponent;
import kr.co.e1.workreport.statistics.di.StatisticsActivityComponent;
import kr.co.e1.workreport.teamreport.di.TeamReportActivityComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    MainActivityComponent.class, StatisticsActivityComponent.class,
    ProjManageActivityComponent.class, OpDetailActivityComponent.class,
    TeamReportActivityComponent.class
}) public class AppModule {
  @Provides Context provideContext(Application application) {
    return application;
  }
}