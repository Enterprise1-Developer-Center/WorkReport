package kr.co.e1.workreport.statistics.fm_operatio.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 22
 */

@ToString @Getter public class OpRatioTotal {
  @SerializedName("USER_NM") String userNm;
  @SerializedName("JAN") float jan;
  @SerializedName("FEB") float feb;
  @SerializedName("MAR") float mar;
  @SerializedName("APR") float apr;
  @SerializedName("MAY") float may;
  @SerializedName("JUN") float jun;
  @SerializedName("JUL") float jul;
  @SerializedName("AUG") float aug;
  @SerializedName("SEP") float sep;
  @SerializedName("OCT") float oct;
  @SerializedName("NOV") float nov;
  @SerializedName("DEC") float dec;
  @SerializedName("CUR_OPR") float curOpr;
  @SerializedName("YEAR_OPR") float yearOpr;
}
