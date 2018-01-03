package kr.co.e1.workreport.main.dialog_login;

import io.reactivex.Single;
import java.util.Map;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.main.dialog_login.model.LoginContent;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.TokenResult;
import kr.co.e1.workreport.network.WResult;
import retrofit2.http.QueryMap;

/**
 * Created by jaeho on 2017. 11. 13
 */

public class LoginNetwork extends NetworkHelper {
  public LoginNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<LoginContent>> getLoginResult(@QueryMap Map<String, String> queryMap) {
    String token = PreferencesUtils.getToken();
    return getWorkReportApi().getLoginResult(token, queryMap);
  }

  public Single<TokenResult> generateToken() {
    return getWorkReportApi().generateToken(confidentialsClient, grantType, scope);
  }
}
