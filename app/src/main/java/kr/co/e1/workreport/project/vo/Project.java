package kr.co.e1.workreport.project.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 29
 */

@ToString @Getter public class Project {
  @SerializedName("PROJ_CD")
  private String proj_cd = "0";
  @SerializedName("PROJ_NM")
  private String proj_nm = "No";
}
