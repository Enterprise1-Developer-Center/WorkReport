package kr.co.e1.workreport.projmanage.frag_emp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kr.co.e1.workreport.framework.utils.ObjectUtils;
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

  public static int indexOf(User user, List<User> users) {
    if (!ObjectUtils.isEmpty(user)) {
      for (int i = 0; i < users.size(); i++) {
        if (user.getUser_id().equals(users.get(i).getUser_id())) {
          return i;
        }
      }
    }
    return -1;
  }
}
