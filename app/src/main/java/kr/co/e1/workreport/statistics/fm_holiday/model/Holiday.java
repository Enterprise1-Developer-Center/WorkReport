package kr.co.e1.workreport.statistics.fm_holiday.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 26
 */

@ToString @Getter public class Holiday {
  @SerializedName("WORK_YMD") private String ymd;
  @SerializedName("HOLIDAY_NM") private String name;
}
