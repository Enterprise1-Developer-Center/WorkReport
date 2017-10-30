package kr.co.e1.workreport.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kr.co.e1.workreport.main.MainActivityComponent;
import kr.co.e1.workreport.settings.SettingsActivityComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { MainActivityComponent.class, SettingsActivityComponent.class })
public class AppModule {
  @Provides @Singleton Context provideContext(Application application) {
    return application;
  }
}
