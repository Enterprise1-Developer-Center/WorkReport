package kr.co.e1.workreport.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * Created by jaeho on 2017. 11. 13
 */

public class DateUtils {
  public static String getIncludeDayOfWeek(@Nonnull String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    int year = Integer.parseInt(date.split("-")[0]);
    int month = Integer.parseInt(date.split("-")[1]) - 1;
    int day = Integer.parseInt(date.split("-")[2]);
    calendar.set(year, month, day);
    Date d = new Date(calendar.getTimeInMillis());
    return dateFormat.format(d);
  }

  public static String getExcludeDayOfWeek(@Nonnull String $date) {
    if ($date.indexOf("(") != -1) {
      String date = $date.substring(0, $date.indexOf(" "));
      return date.trim();
    } else {
      return $date.trim();
    }
  }

  public static Map<String, Integer> getYmdMap(@Nonnull String date) {
    Map<String, Integer> map = new HashMap<>();
    map.put("year", Integer.parseInt(date.split("-")[0]));
    map.put("month", Integer.parseInt(date.split("-")[1]));
    map.put("day", Integer.parseInt(date.split("-")[2]));
    return map;
  }

  public static int getMonthOfYear(int month) {
    return month - 1;
  }

  public static Map<String, Integer> convertTimeToMap(@Nonnull String time) {
    Map<String, Integer> map = new HashMap<>();
    map.put("hour", Integer.parseInt(time.split(":")[0]));
    map.put("minute", Integer.parseInt(time.split(":")[1]));
    return map;
  }

  public static long convertTimeToMillis(int hourOfDay, int minute) {
    Calendar cal = Calendar.getInstance();
    cal.set(0, 0, 0, hourOfDay, minute);
    return cal.getTimeInMillis();
  }

  public static String getConvertoFormat(Date date, String pattern) {
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    return format.format(date).trim();
  }

  public static String getDateString(int year, int month, int dayOfMonth, String pattern) {
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    return format.format(calendar.getTime());
  }

  public static String getDateString(int year, int month, int dayOfMonth, String pattern, Locale locale) {
    SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    return format.format(calendar.getTime());
  }
}