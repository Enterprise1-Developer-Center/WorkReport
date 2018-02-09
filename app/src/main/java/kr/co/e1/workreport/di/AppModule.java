package kr.co.e1.workreport.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kr.co.e1.workreport.main.di.MainActivityComponent;
import kr.co.e1.workreport.projmanage.di.ProjManageActivityComponent;
import kr.co.e1.workreport.statistics.ac_detail.OpDetailActivityComponent;
import kr.co.e1.workreport.statistics.di.StatisticsActivityComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    MainActivityComponent.class, StatisticsActivityComponent.class, OpDetailActivityComponent.class,
    ProjManageActivityComponent.class
}) public class AppModule {
  @Provides @Singleton Context provideContext(Application application) {
    return application;
  }
}
