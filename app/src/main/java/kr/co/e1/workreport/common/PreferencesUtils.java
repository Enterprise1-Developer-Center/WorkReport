package kr.co.e1.workreport.common;

import com.pixplicity.easyprefs.library.Prefs;
import java.util.Date;
import kr.co.e1.workreport.framework.utils.DateUtils;

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

  public static void setToday(String date) {
    Prefs.putString("today", date);
  }

  public static String getToday() {
    return Prefs.getString("today", DateUtils.getConvertoFormat(new Date(), "yyyy-MM-dd"));
  }

  public static void setDeptCd(String code) {
    Prefs.putString("deptCd", code);
  }

  public static String getDeptCd() {
    return Prefs.getString("deptCd", null);
  }

  public static void setAdmin(boolean admin) {
    Prefs.putBoolean("admin", admin);
  }

  public static boolean isAdmin() {
    return Prefs.getBoolean("admin", false);
  }
}
