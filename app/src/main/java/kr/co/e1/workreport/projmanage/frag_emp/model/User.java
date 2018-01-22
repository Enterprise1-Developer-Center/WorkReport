package kr.co.e1.workreport.projmanage.frag_emp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 19
 */

@Getter @ToString public class User {
  @SerializedName("USER_ID") private String user_id;
  @SerializedName("USER_NM") private String user_nm;

  public static String[] convertToNameArray(List<User> users) {
    String[] names = new String[users.size()];
    for (int i = 0; i < users.size(); i++) {
      names[i] = users.get(i).getUser_nm();
    }
    return names;
  }

  public static int indexOf(String[] names, String name) {
    for (int i = 0; i < names.length; i++) {
      if (names[i].equals(name)) {
        return i;
      }
    }
    return 0;
  }
}
