package kr.co.e1.workreport.common;

import android.support.annotation.DrawableRes;
import kr.co.e1.workreport.R;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 11. 10
 */

public enum ReportType {

  DATE(R.drawable.ic_today, 0),
  DEPT(R.drawable.ic_group, 1),
  NAME(R.drawable.ic_person, 2),
  START_TIME(R.drawable.ic_timer, 3),
  END_TIME(R.drawable.ic_timer_off, 4),
  WORKING_TIME(R.drawable.ic_timelapse, 5),
  DETAIL_WORK(R.drawable.ic_format_list_numbered, 6),
  PROJECT(R.drawable.ic_train, 7),
  MODIFIED_TIME(R.drawable.ic_edit, 8);

  @Getter private @DrawableRes int resId;
  @Getter private int position;

  private ReportType(@DrawableRes int resId, int position) {
    this.resId = resId;
    this.position = position;
  }
}
