package kr.co.e1.workreport.statistics.fm_operation.model;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 8
 */

@ToString @Getter public class CurrOperationRate {
  private String user_id;
  private String user_nm;
  private float man_rate;
  private float tot_rate;
}
