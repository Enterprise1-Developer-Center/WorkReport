package kr.co.e1.workreport.projmanage.frag_emp.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 18
 */

@Getter @ToString public class Employee {
  @SerializedName("PROJ_CD") private String proj_cd;
  @SerializedName("USER_ID") private String user_id;
  @SerializedName("USER_SDATE") private String user_sdate;
  @SerializedName("USER_EDATE") private String user_edate;
  @SerializedName("LCLS_CD") private String lcls_cd;
  @SerializedName("MCLS_CD") private String mcls_cd;
  @SerializedName("USER_NM") private String user_nm;
  @SerializedName("PROJ_NM") private String proj_nm;
}
