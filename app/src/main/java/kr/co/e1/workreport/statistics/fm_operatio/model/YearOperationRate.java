package kr.co.e1.workreport.statistics.fm_operatio.model;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 8
 */

@ToString @Getter public class YearOperationRate {
  private String mon;
  private float mon_rate;
  private float tot_rate;
}
