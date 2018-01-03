package kr.co.e1.workreport.statistics;

import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 3
 */

public enum BottomNav {
  RATIO(0), TOTAL(1), ANALY(2), HOLID(3);

  @Getter private int value;

  private BottomNav(int value) {
    this.value = value;
  }
}
