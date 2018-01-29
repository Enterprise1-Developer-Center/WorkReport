package kr.co.e1.workreport.statistics.fm_holiday.model;

import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 29
 */

@ToString @Getter public class LegalHoliday {
  private String name;

  public static String[] convertToNameArray(List<LegalHoliday> items) {
    String[] names = new String[items.size()];
    for (int i = 0; i < names.length; i++) {
      names[i] = items.get(i).getName();
    }
    return names;
  }

  public static int indexOf(String name, String[] names) {
    for (int i = 0; i < names.length; i++) {
      if(names[i].equals(name)) {
        return i;
      }
    }
    return -1;
  }
}