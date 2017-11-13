package kr.co.e1.workreport.common.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 13
 */

@ToString @Getter public class ReportContent {
  @SerializedName("S_TIME") private String sTime;
  @SerializedName("USER_NM") private String userName;
  @SerializedName("PROJ") private Projects projects;
  @SerializedName("USER_ID") private String userId;
  @SerializedName("E_TIME") private String eTime;
  @SerializedName("EXTRA_TIME") private String extraTime;
  @SerializedName("DEPT_NM") private String deptName;
  @SerializedName("WORK_YMD") private String date;
  @SerializedName("MCLS") private DetailWork detailWork;
  @SerializedName("UPD_TIME") private String updTime;
}
