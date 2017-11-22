package kr.co.e1.workreport.statisticsop.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 22
 */

@ToString @Getter public class OpRatioContent {
  @SerializedName("header") private OpRatioHeader header;
  @SerializedName("op_ratio_list") private List<OpRatioItem> opRatios;
  @SerializedName("total") private OpRatioTotal opRatioTotal;
}
