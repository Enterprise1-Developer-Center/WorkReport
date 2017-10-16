package kr.co.e1.workreport.login;

import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import java.net.URI;
import java.net.URISyntaxException;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 13
 */

public class LoginNetworking {
  private final static String BASE_URL = "/adapters/WorkReportSQL/";
  private final static String LOGIN_PATH = "login/";

  public void doLogin(String id, String pw) {
    check();
  }

  private void check() {
    try {
      URI adapterPath = new URI(BASE_URL + LOGIN_PATH + "jhoh" +"/" + "2222");
      WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.GET);
      // Query Parameters
      //request.setQueryParameter("age", "36");

      // Header Parameters
      //request.addHeader("birthdate", "820601");

      // Form Parameters
      //HashMap<String, String> formParams = new HashMap<>();
      //formParams.put("userId", "jhoh");
      //formParams.put("userPw", "1111");
      // Send
      request.send(new WLResponseListener() {
        public void onSuccess(WLResponse response) {
          if(response != null) {
            String responseText = response.getResponseText();
            String jsonString = response.getResponseJSON().toString();
            Timber.d("success text = " + responseText);
            Timber.d("success json = " + jsonString);
          } else {
            Timber.d("null");
          }
        }

        public void onFailure(WLFailResponse response) {
          String errorMsg = response.getErrorMsg();
          Timber.d("code = " + response.getErrorStatusCode());
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }
}