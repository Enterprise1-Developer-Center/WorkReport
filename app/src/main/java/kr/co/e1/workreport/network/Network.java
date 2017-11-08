package kr.co.e1.workreport.network;

import com.google.gson.Gson;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import hugo.weaving.DebugLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.app.MyApplication;
import org.json.JSONException;

/**
 * Created by jaeho on 2017. 11. 7
 */

public abstract class Network {
  private final static int RESULT_SUCCESS = 1;
  private final static int RESULT_FAILURE = 0;
  private boolean isRunning = false;
  private String url;
  protected Gson gson;

  public Network(String url) {
    this.url = url;
    gson = new Gson();
  }

  public void execute() {
    isRunning = true;
    onPre();
    try {
      URI adapterPath = new URI(url);
      WLResourceRequest request = new WLResourceRequest(adapterPath, getMethod(), getTimeOut());
      // Query Parameters
      request.setQueryParameters(getParameters());

      // Send
      request.send(new WLResponseListener() {
        @DebugLog public void onSuccess(WLResponse response) {
          if(!isRunning) {
            return;
          }
          int result = 0;
          try {
            result = response.getResponseJSON().getInt("result");
          } catch (JSONException e) {
          }
          switch (result) {
            case RESULT_SUCCESS:
              onResultSuccess(response);
              onPost();
              break;
            case RESULT_FAILURE:
              onResultFailure(response);
              onPost();
              break;
          }

          isRunning = false;
        }

        @DebugLog public void onFailure(WLFailResponse response) {
          String errorMsg = MyApplication.getInstance().getString(R.string.error_server_error);
          onServerError(errorMsg);
          onPost();
          isRunning = false;
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
      onServerError(null);
      onPost();
      isRunning = false;
    } catch (Exception e) {
      e.printStackTrace();
      onServerError(null);
      onPost();
      isRunning = false;
    }
  }
  public void cancel() {
    isRunning = false;
  }
  protected abstract int getTimeOut();

  protected abstract void onPre();

  protected abstract void onPost();

  protected abstract void onServerError(String msg);

  protected abstract void onResultFailure(WLResponse response);

  protected abstract void onResultSuccess(WLResponse response);

  protected abstract HashMap<String, String> getParameters();

  protected abstract String getMethod();
}
