package kr.co.e1.workreport.projmanage;

import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 12
 */

public enum ProjMPos {
  PROJ(0), EMPL(1);

  @Getter private int value;

  private ProjMPos(int value) {
    this.value = value;
  }
}
