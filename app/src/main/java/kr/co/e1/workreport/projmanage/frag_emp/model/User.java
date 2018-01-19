package kr.co.e1.workreport.projmanage.frag_emp.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 19
 */

@Getter @ToString public class User {
  @SerializedName("USER_ID") private String user_id;
  @SerializedName("USER_NM") private String user_nm;
}
