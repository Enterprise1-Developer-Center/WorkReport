package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 22
 */

@ToString @Getter public class UserType {
  @SerializedName("TYPE_CD") private String typeCd;
  @SerializedName("TYPE_NM") private String typeNm;

  public static String[] convertToNameArray(List<UserType> userTypes) {
    String[] names = new String[userTypes.size()];
    for (int i = 0; i < userTypes.size(); i++) {
      names[i] = userTypes.get(i).getTypeNm();
    }

    return names;
  }

  public static int indexOf(String typeName, List<UserType> userTypes) {
    for (int i = 0; i < userTypes.size(); i++) {
      if (typeName.equals(userTypes.get(i))) {
        return i;
      }
    }
    return 0;
  }

  public static List<String> convertToNameList(List<UserType> userTypes) {
    List<String> names = new ArrayList<>();
    for (UserType userType : userTypes) {
      names.add(userType.getTypeNm());
    }
    return names;
  }
}
