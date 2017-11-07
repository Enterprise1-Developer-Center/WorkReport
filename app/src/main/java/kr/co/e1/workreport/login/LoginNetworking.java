package kr.co.e1.workreport.login;

import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import hugo.weaving.DebugLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import kr.co.e1.workreport.network.Network;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 13
 */

public class LoginNetworking extends Network {
  public LoginNetworking(String url) {
    super(url);
  }
  //private final static String BASE_URL = "/adapters/WorkReportSQL/";
  //private final static String LOGIN_PATH = "login/";

  @DebugLog public void doLogin(String id, String pw) {
    try {
      URI adapterPath = new URI(getUrl());
      WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.GET);
      // Query Parameters
      HashMap<String, String> parameters = new HashMap<>();
      parameters.put("userId", id);
      parameters.put("userPw", pw);
      request.setQueryParameters(parameters);
      // Send
      request.send(new WLResponseListener() {
        @DebugLog public void onSuccess(WLResponse response) {
          if (response != null) {
            String responseText = response.getResponseText();
            String jsonString = response.getResponseJSON().toString();
            Timber.d("success text = " + responseText);
            Timber.d("success json = " + jsonString);
          } else {
            Timber.d("null");
          }
        }

        @DebugLog public void onFailure(WLFailResponse response) {
          String errorMsg = response.getErrorMsg();
          Timber.d("code = " + response.getErrorStatusCode());
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
      Timber.d(e.getMessage());
    }
  }

  private void check() {

  }
}