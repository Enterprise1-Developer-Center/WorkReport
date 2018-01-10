package kr.co.e1.workreport.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.leakcanary.LeakCanary;
import com.worklight.common.WLAnalytics;
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

  public static boolean DEBUG = false;
  public static String BASE_URL = "http://192.168.1.99:9080/mfp/";

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    initBaseUrl();
    initDebuggable();
    initLeakCanary();
    initTimber();
    initWLClient();
    initDagger();
    initEasyPrefs();
  }

  private void initBaseUrl() {
    if (isDebuggable(this)) {
      BASE_URL = "http://192.168.1.99:9080/mfp/";
    } else {
      BASE_URL = "http://211.219.71.228:9080/mfp/";
    }
  }

  private void initDebuggable() {
    this.DEBUG = isDebuggable(this);
  }

  private void initEasyPrefs() {
    new Prefs.Builder().setContext(this)
        .setMode(ContextWrapper.MODE_PRIVATE)
        .setPrefsName(getPackageName())
        .setUseDefaultSharedPreference(true)
        .build();
  }

  private boolean isDebuggable(Context context) {
    boolean debuggable = false;

    PackageManager pm = context.getPackageManager();
    try {
      ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
      debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
    } catch (PackageManager.NameNotFoundException e) {
      /* debuggable variable will remain false */
    }

    return debuggable;
  }

  private void initDagger() {
    DaggerAppComponent.builder().application(this).build().inject(this);
  }

  private void initWLClient() {
    WLClient.createInstance(this);
    WLAnalytics.init(this);
    WLAnalytics.addDeviceEventListener(WLAnalytics.DeviceEvent.LIFECYCLE);
    WLAnalytics.addDeviceEventListener(WLAnalytics.DeviceEvent.NETWORK);
  }

  private void initLeakCanary() {
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    LeakCanary.install(this);
    // Normal app init code...
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
