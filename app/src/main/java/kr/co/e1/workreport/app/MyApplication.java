package kr.co.e1.workreport.app;

import android.app.Activity;
import android.app.Application;
import com.worklight.wlclient.api.WLClient;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;
import kr.co.e1.workreport.BuildConfig;
import kr.co.e1.workreport.di.DaggerAppComponent;
import lombok.Getter;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 9. 22
 */

public class MyApplication extends Application implements HasActivityInjector {
  @Getter private static Application instance;
  @Inject DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    initTimber();
    WLClient.createInstance(this);
    DaggerAppComponent.builder().application(this).build().inject(this);
  }

  private void initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  @Override public AndroidInjector<Activity> activityInjector() {
    return activityDispatchingAndroidInjector;
  }
}
