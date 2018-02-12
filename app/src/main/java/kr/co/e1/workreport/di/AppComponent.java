package kr.co.e1.workreport.di;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import kr.co.e1.workreport.app.MyApplication;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Component(modules = {
    AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class
}) public interface AppComponent {
  @Component.Builder interface Builder {
    @BindsInstance AppComponent.Builder application(Application application);

    AppComponent build();
  }

  void inject(MyApplication app);
}