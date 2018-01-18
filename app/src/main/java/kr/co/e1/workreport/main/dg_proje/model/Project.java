package kr.co.e1.workreport.main.dg_proje.model;

import com.google.gson.annotations.SerializedName;
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
}
