package kr.co.e1.workreport.main.dg_proje.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 29
 */

@ToString @Getter public class Project {
  @SerializedName("PROJ_CD") private String proj_cd = "0";
  @SerializedName("PROJ_NM") private String proj_nm = "No";
  @SerializedName("PROJ_SDATE") private String proj_sdate;
  @SerializedName("PROJ_EDATE") private String proj_edate;
  @SerializedName("DEPT_CD") private String dept_cd;

  public static String[] convertToNameArray(List<Project> projects) {
    String[] names = new String[projects.size()];
    for (int i = 0; i < projects.size(); i++) {
      names[i] = projects.get(i).getProj_nm();
    }
    return names;
  }

  public static int indexOfName(String projName, List<Project> projects) {
    for (int i = 0; i < projects.size(); i++) {
      if (projName.equals(projects.get(i).getProj_nm())) {
        return i;
      }
    }
    return 0;
  }
}
