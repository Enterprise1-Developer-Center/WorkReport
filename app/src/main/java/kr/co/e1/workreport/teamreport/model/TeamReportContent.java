package kr.co.e1.workreport.teamreport.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 20
 */

@ToString @Getter public class TeamReportContent {
  @SerializedName("NAME") private String name;
  @SerializedName("PROJ_NM") private String proj_nm;
  @SerializedName("DETAIL") private String detail;
  @SerializedName("MCLS_CD") private String mcls_cd;
  @SerializedName("USER_ID") private String user_id;
}
