package kr.co.e1.workreport.common.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 11. 13..
 */

@Getter public class DetailWork {
  @SerializedName("DETAIL") private String detail;
  @SerializedName("MCLS_CD") private String code;
}
