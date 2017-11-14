package kr.co.e1.workreport.classificationdialog.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 24
 */

@ToString @Getter public class ClassificationCode {
  @SerializedName("LCLS_NM") private String majorClassName;
  @SerializedName("LCLS_CD") private int majorClassCode;
  @SerializedName("MCLS_NM") private String smallClassName;
  @SerializedName("MCLS_CD") private int smallClassCode;
  @SerializedName("REMARK") private String classDesc;
}
