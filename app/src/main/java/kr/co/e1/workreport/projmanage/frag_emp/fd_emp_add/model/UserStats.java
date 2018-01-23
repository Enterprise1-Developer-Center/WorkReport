package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kr.co.e1.workreport.framework.utils.ObjectUtils;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 22
 */

@ToString @Getter public class UserStats {
  @SerializedName("STATS") private String stats;
  @SerializedName("STATS_NM") private String statsNm;

  public static String[] convertToNameArray(List<UserStats> userTypes) {
    String[] names = new String[userTypes.size()];
    for (int i = 0; i < userTypes.size(); i++) {
      names[i] = userTypes.get(i).getStatsNm();
    }
    return names;
  }

  public static int indexOf(String typeName, List<UserStats> userTypes) {
    for (int i = 0; i < userTypes.size(); i++) {
      if (typeName.equals(userTypes.get(i))) {
        return i;
      }
    }
    return -1;
  }

  public static int indexOf(UserStats userStats, List<UserStats> userTypes) {
    if (!ObjectUtils.isEmpty(userStats)) {
      for (int i = 0; i < userTypes.size(); i++) {
        if (userStats.getStats().equals(userTypes.get(i).getStats())) {
          return i;
        }
      }
    }
    return -1;
  }
}
