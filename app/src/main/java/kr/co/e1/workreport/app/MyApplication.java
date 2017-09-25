package kr.co.e1.workreport.app;

import android.app.Application;
import com.worklight.wlclient.api.WLClient;

/**
 * Created by jaeho on 2017. 9. 22
 */

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    WLClient.createInstance(this);
  }
}
