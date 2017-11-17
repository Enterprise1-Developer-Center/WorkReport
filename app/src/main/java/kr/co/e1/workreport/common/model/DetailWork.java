package kr.co.e1.workreport.common.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 11. 13
 */

@Getter public class DetailWork {
  @Accessors(chain = true) @SerializedName("DETAIL") @Setter private String detail = "";
  @SerializedName("LCLS_NM") private String lcls_nm = "No";
  @SerializedName("LCLS_CD") private String lcls_cd = "0";
  @SerializedName("MCLS_NM") private String mcls_nm = "no";
  @SerializedName("MCLS_CD") private String mcls_cd = "no";
  @SerializedName("REMARK") private String remark = "no";
}
