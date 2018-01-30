package kr.co.e1.workreport.statistics;

import kr.co.e1.workreport.statistics.fm_analytics.AnalyticsFragment;
import kr.co.e1.workreport.statistics.fm_holiday.HolidayFragment;
import kr.co.e1.workreport.statistics.fm_operation.OperationFragment;
import kr.co.e1.workreport.statistics.fm_total.TotalFragment;
import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 3
 */

public enum BottomNav {
  RATIO(0, OperationFragment.class.getSimpleName()),
  TOTAL(1, TotalFragment.class.getSimpleName()),
  ANALY(2, AnalyticsFragment.class.getSimpleName()),
  HOLID(3, HolidayFragment.class.getSimpleName());

  @Getter private int position;
  @Getter private String fName;

  private BottomNav(int value, String fName) {
    this.position = value;
    this.fName = fName;
  }
}
