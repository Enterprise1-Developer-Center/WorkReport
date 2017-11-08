package kr.co.e1.workreport.network;

import lombok.AllArgsConstructor;

/**
 * Created by jaeho on 2017. 11. 8
 */

@AllArgsConstructor public class MFPTokenBody {
  private String grant_type;
  private String scope;

  public String toString() {
    return "grant_type = " + grant_type + "scope = " + scope;
  }
}
