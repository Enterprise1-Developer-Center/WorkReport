package kr.co.e1.workreport.network;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 8
 */

@ToString @Getter public class TokenResult {
  private String access_token;
  private String token_type;
  private int expires_in;
  private String scope;
}
