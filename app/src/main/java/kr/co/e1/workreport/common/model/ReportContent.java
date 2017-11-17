package kr.co.e1.workreport.common.model;

import com.google.gson.annotations.SerializedName;
import kr.co.e1.workreport.project.vo.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 13
 */

@ToString @Getter public class ReportContent {
  @SerializedName("S_TIME") private String s_time;
  @SerializedName("USER_NM") private String user_nm;
  @SerializedName("PROJ") @Setter private Project proj;
  @SerializedName("USER_ID") private String user_id;
  @SerializedName("E_TIME") private String e_time;
  @SerializedName("EXTRA_TIME") private String extra_time;
  @SerializedName("DEPT_NM") private String dept_nm;
  @SerializedName("WORK_YMD") private String work_ymd;
  @SerializedName("MCLS") @Setter private DetailWork mcls;
  @SerializedName("UPD_TIME") private String upd_time;
  private Project project;

}
