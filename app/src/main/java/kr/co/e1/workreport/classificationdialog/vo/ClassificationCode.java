package kr.co.e1.workreport.classificationdialog.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 24
 */

@ToString @Getter public class ClassificationCode {
  @SerializedName("LCLS_NM") private String majorClassName = "No";
  @SerializedName("LCLS_CD") private String majorClassCode = "0";
  @SerializedName("MCLS_NM") private String smallClassName = "no";
  @SerializedName("MCLS_CD") private String smallClassCode = "no";
  @SerializedName("REMARK") private String classDesc = "no";
}
