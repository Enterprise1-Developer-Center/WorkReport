package kr.co.e1.workreport.common;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by jaeho on 2017. 11. 13
 */

public class PreferencesUtils {

  public synchronized static void setToken(String type, String token) {
    Prefs.putString("token", type + " " + token);
  }

  public synchronized static String getToken() {
    return Prefs.getString("token", null);
  }

  public static String getUserId() {
    return Prefs.getString("userId", null);
  }

  public static void setUserId(String userId) {
    Prefs.putString("userId", userId);
  }

  public static void setDept(String dept) {
    Prefs.putString("dept", dept);
  }

  public static String getDept() {
    return Prefs.getString("dept", null);
  }
}
