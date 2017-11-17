package kr.co.e1.workreport.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

  public static String getOnlyDateString(@Nonnull String content) {
    if (content.indexOf(" ") != -1) {
      int index = content.indexOf(" ");
      return content.substring(0, index).trim();
    } else {
      return content.trim();
    }
  }

  public static Map<String, Integer> getYearMonthDayMap(@Nonnull String date) {
    Map<String, Integer> map = new HashMap<>();
    map.put("year", Integer.parseInt(date.split("-")[0]));
    map.put("month", Integer.parseInt(date.split("-")[1]));
    map.put("day", Integer.parseInt(date.split("-")[2]));
    return map;
  }

  public static int getMonthOfYear(int month) {
    return month - 1;
  }

  public static Map<String, Integer> getOnlyTimeMap(@Nonnull String dateTime) {
    Map<String, Integer> map = new HashMap<>();
    map.put("hour", Integer.parseInt(dateTime.split(" ")[1].split(":")[0]));
    map.put("minute", Integer.parseInt(dateTime.split(" ")[1].split(":")[1]));
    return map;
  }

  /**
   * @return Map<String, Integer>
   */
  public static Map<String, Integer> getTimeMap(@Nonnull String time) {
    Map<String, Integer> map = new HashMap<>();
    map.put("hour", Integer.parseInt(time.split(":")[0]));
    map.put("minute", Integer.parseInt(time.split(":")[1]));
    return map;
  }
  public static Map<String, Integer> convertTimeToMap(@Nonnull String time) {
    Map<String, Integer> map = new HashMap<>();
    map.put("hour", Integer.parseInt(time.split(":")[0]));
    map.put("minute", Integer.parseInt(time.split(":")[1]));
    return map;
  }

  public static long getTimeInMillis(int year, int month, int day, int hourOfDay, int minute) {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month, day, hourOfDay, minute);
    return cal.getTimeInMillis();
  }

  public static long convertTimeToMillis(int hourOfDay, int minute) {
    Calendar cal = Calendar.getInstance();
    cal.set(0, 0, 0, hourOfDay, minute);
    return cal.getTimeInMillis();
  }

  public static long convertMinuteToMillisecond(int hourOfDay, int minute) {
    Calendar cal = Calendar.getInstance();
    cal.set(0, 0, 0, hourOfDay, minute);
    return cal.getTimeInMillis();
  }

  public static String getConvertoFormat(Date date, String pattern) {
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    return format.format(date).trim();
  }
}