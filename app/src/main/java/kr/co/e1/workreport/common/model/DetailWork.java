package kr.co.e1.workreport.common.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 11. 13
 */

@Getter public class DetailWork {
  @SerializedName("DETAIL") @Setter private String DETAIL = "";
  @SerializedName("LCLS_NM") private String LCLS_NM = "No";
  @SerializedName("LCLS_CD") private String LCLS_CD = "0";
  @SerializedName("MCLS_NM") private String MCLS_NM = "no";
  @SerializedName("MCLS_CD") private String MCLS_CD = "no";
  @SerializedName("REMARK") private String REMARK = "no";
}
