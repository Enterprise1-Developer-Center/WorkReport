package kr.co.e1.workreport.common;

import hugo.weaving.DebugLog;
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
  @DebugLog public static String getIncludeDayOfWeek(@Nonnull String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    int year = Integer.parseInt(date.split("-")[0]);
    int month = Integer.parseInt(date.split("-")[1]) - 1;
    int day = Integer.parseInt(date.split("-")[2]);
    calendar.set(year, month, day);
    Date d = new Date(calendar.getTimeInMillis());
    return dateFormat.format(d);
  }

  public static String getRemoveDayOfWeekDate(@Nonnull String date) {
    return date.split(" ")[0];
  }

  public static Map<String, Integer> getYearMonthDayMap(@Nonnull String date) {
    Map<String, Integer> map = new HashMap<>();
    map.put("year", Integer.parseInt(date.split("-")[0]));
    map.put("month", Integer.parseInt(date.split("-")[1]));
    map.put("day", Integer.parseInt(date.split("-")[2]));
    return map;
  }
}
