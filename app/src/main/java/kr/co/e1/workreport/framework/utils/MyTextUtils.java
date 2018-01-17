package kr.co.e1.workreport.framework.utils;

/**
 * Created by jaeho on 2018. 1. 17
 */

public final class MyTextUtils {
  public static boolean isEmpty(final CharSequence s) {
    if (s == null) {
      return true;
    }
    return s.length() == 0;
  }

  public static boolean isBlank(final CharSequence s) {
    if (s == null) {
      return true;
    }
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isWhitespace(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
