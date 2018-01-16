package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 16
 */

@Getter @ToString public class Dept {
  @SerializedName("DEPT_CD") private int dept_cd;
  @SerializedName("DEPT_NM") private String dept_nm;

  public static List<String> convertToNames(List<Dept> depts) {
    List<String> names = new ArrayList<>();
    for (Dept dept : depts) {
      names.add(dept.getDept_nm());
    }
    return names;
  }

  public static String[] convertToNameArray(List<Dept> depts) {
    String[] names = new String[depts.size()];
    for (int i = 0; i < depts.size(); i++) {
      names[i] = depts.get(i).getDept_nm();
    }
    return names;
  }
}
