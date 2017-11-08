package kr.co.e1.workreport.login;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.main.LoginCommunicationListener;
import kr.co.e1.workreport.network.OnWLResultListener;
import kr.co.e1.workreport.network.WLResult;

/**
 * Created by jaeho on 2017. 9. 27
 */

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

  private LoginFragmentPresenter.View view;
  private LoginNetworking networking;
  private LoginCommunicationListener loginListener;

  @Inject LoginFragmentPresenterImpl(LoginFragmentPresenter.View view, LoginNetworking networking,
      LoginCommunicationListener loginListener) {
    this.view = view;
    this.networking = networking;
    this.loginListener = loginListener;
  }

  @DebugLog @Override public void onActivityCreate(Bundle savedInstanceState) {
  }

  @Override public void onPositiveClick(String id, String pw, LoginCommunicationListener listener) {

    networking.setUser(id, pw).setOnWLResultListener(new OnWLResultListener<WLResult>() {
      @Override public void onPre() {
        view.showProgress();
        view.setButtonEnabled(false);
      }

      @DebugLog @Override public void onResultSuccess(WLResult result) {
        loginListener.loginComplete();
        view.dismiss();
      }

      @DebugLog @Override public void onResultFailure(WLResult result) {
        view.showMessage(result.getMsg());
      }

      @DebugLog @Override public void onServerError(String msg) {
        view.showMessage(msg);
      }

      @Override public void onPost() {
        view.hideProgress();
        view.setButtonEnabled(true);
      }
    }).execute();
  }

  @DebugLog @Override public void onDetach() {
    networking.cancel();
  }
}