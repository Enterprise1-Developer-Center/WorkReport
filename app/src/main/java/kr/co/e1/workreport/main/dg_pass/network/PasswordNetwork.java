package kr.co.e1.workreport.main.dg_pass.network;

import io.reactivex.Single;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 20
 */

public class PasswordNetwork extends NetworkHelper<PasswordApi> {
  public PasswordNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<PasswordApi> getApiClass() {
    return PasswordApi.class;
  }

  public Single<WResult> changePw(String nowPw, String newPw, String newPwConfirm) {
    String header = PreferencesUtils.getToken();
    String userId = PreferencesUtils.getUserId();
    return getApi().changePwd(header, userId, nowPw, newPw, newPwConfirm);
  }
}
