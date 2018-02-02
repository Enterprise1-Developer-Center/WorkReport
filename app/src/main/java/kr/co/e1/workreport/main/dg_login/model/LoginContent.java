package kr.co.e1.workreport.main.dg_login.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 11. 13
 */

public class LoginContent {
  @SerializedName("date") @Getter private String date;
  @SerializedName("USER_ID") @Getter private String userId;
  @SerializedName("DEPT_NM") @Getter private String deptNm;
  @SerializedName("DEPT_CD") @Getter private String deptCd;
  @SerializedName("ADMIN") @Getter private boolean admin;
}