package kr.co.e1.workreport.login;

import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import java.util.HashMap;
import kr.co.e1.workreport.network.Network;
import kr.co.e1.workreport.network.OnWLResultListener;
import kr.co.e1.workreport.network.WLResult;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 13
 */

public class LoginNetworking extends Network {

  public LoginNetworking(String url) {
    super(url);
  }

  @Override protected int getTimeOut() {
    return 1000 * 5;
  }

  @Override protected void onPre() {
    if (onWLResultListener != null) {
      onWLResultListener.onPre();
    }
  }

  @Override protected void onPost() {
    if (onWLResultListener != null) {
      onWLResultListener.onPost();
    }
  }

  @Accessors(chain = true) @Setter private OnWLResultListener<WLResult> onWLResultListener;

  @Override protected void onServerError(String msg) {
    if (onWLResultListener != null) {
      onWLResultListener.onServerError(msg);
    }
  }

  @Override protected void onResultFailure(WLResponse response) {
    String json = response.getResponseJSON().toString();
    WLResult result = gson.fromJson(json, WLResult.class);
    if (onWLResultListener != null) {
      onWLResultListener.onResultFailure(result);
    }
  }

  @Override protected void onResultSuccess(WLResponse response) {
    String json = response.getResponseJSON().toString();
    WLResult result = gson.fromJson(json, WLResult.class);
    if (onWLResultListener != null) {
      onWLResultListener.onResultSuccess(result);
    }
  }

  private String id;
  private String pw;

  public LoginNetworking setUser(String id, String pw) {
    this.id = id;
    this.pw = pw;
    return this;
  }

  @Override protected HashMap<String, String> getParameters() {
    HashMap<String, String> parameters = new HashMap<>();
    parameters.put("userId", id);
    parameters.put("userPw", pw);
    return parameters;
  }

  @Override protected String getMethod() {
    return WLResourceRequest.GET;
  }
}