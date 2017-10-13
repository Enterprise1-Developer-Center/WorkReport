package kr.co.e1.workreport.login;

import android.util.Log;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import java.net.URI;
import java.net.URISyntaxException;
import kr.co.e1.workreport.framework.Req;

/**
 * Created by jaeho on 2017. 10. 13
 */

public class Networking extends Req {

  public Networking(String url) {
    super(url);
  }

  public static void doLogin(String id, String pw) {

  }

  private void getUser() {
    try {
      // Path Parameters (user id)
      URI adapterPath = new URI("/adapters/JavaSQL/resource" + "mobile");
      WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.GET);
      // Query Parameters
      //request.setQueryParameter("age", "36");

      // Header Parameters
      //request.addHeader("birthdate", "820601");

      // Form Parameters
      //HashMap<String, String> formParams = new HashMap<>();
      //formParams.put("height", "167");

      // Send
      request.send(new WLResponseListener() {
        public void onSuccess(WLResponse response) {
          String responseText = response.getResponseText();
          String resultText = "";

          try {
            resultText += "Name = "
                + response.getResponseJSON().getString("first")
                + " "
                + response.getResponseJSON().getString("middle")
                + " "
                + response.getResponseJSON().getString("last")
                + "\n";
            resultText += "Age = " + response.getResponseJSON().getInt("age") + "\n";
            resultText += "Height = " + response.getResponseJSON().getString("height") + "\n";
            resultText += "Birthdate = " + response.getResponseJSON().getString("birthdate");
          } catch (org.json.JSONException e) {
            e.printStackTrace();
          }

          Log.d("InvokeSuccess", responseText + "\n" + resultText);
          Log.d("InvokeSuccess2", response.getResponseJSON().toString());
          //updateTextView(resultText);
          //Toast.makeText(MainActivity.this, resultText, Toast.LENGTH_SHORT).show();
        }

        public void onFailure(WLFailResponse response) {
          //String responseText = response.getResponseText();
          String errorMsg = response.getErrorMsg();
          Log.d("InvokeFail", errorMsg);
            /*
            Toast.makeText(MainActivity.this, "Failed to Invoke Adapter Procedure",
                Toast.LENGTH_SHORT).show();
            */
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }
}
