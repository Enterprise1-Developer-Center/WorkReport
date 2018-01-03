package kr.co.e1.workreport.statistics.operatio.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 22
 */

@ToString @Getter public class OpRatioHeader {
  @SerializedName("USER_ID") String id;
  @SerializedName("USER_NM") String userNm;
  @SerializedName("JAN") String jan;
  @SerializedName("FEB") String feb;
  @SerializedName("MAR") String mar;
  @SerializedName("APR") String apr;
  @SerializedName("MAY") String may;
  @SerializedName("JUN") String jun;
  @SerializedName("JUL") String jul;
  @SerializedName("AUG") String aug;
  @SerializedName("SEP") String sep;
  @SerializedName("OCT") String oct;
  @SerializedName("NOV") String nov;
  @SerializedName("DEC") String dec;
  @SerializedName("CUR_OPR") String curOpr;
  @SerializedName("YEAR_OPR") String yearOpr;
}
