package kr.co.e1.workreport.network;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 7
 */

@ToString public class WResult<T> {
  public final static int RESULT_SUCCESS = 1;
  public final static int RESULT_FAILURE = 0;

  @Getter private int result;
  @Getter private String msg;
  @Getter private T content;
}
