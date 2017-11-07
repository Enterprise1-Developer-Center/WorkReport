package kr.co.e1.workreport.network;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 11. 7
 */

@AllArgsConstructor public abstract class Network {
  private final static String BASE_URL = "/adapters/WorkReportSQL/";
  @Getter private String url;

  protected String getUrl() {

    return BASE_URL + url;
  }
}
