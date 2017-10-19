package kr.co.e1.workreport.login;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 27
 */

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

  LoginFragmentPresenter.View view;

  @Inject LoginFragmentPresenterImpl(LoginFragmentPresenter.View view) {
    this.view = view;
  }

  @DebugLog @Override public void onActivityCreate(Bundle savedInstanceState) {
    //view.setEditTextFilter();
  }

  @Override public void onLoginClick(String id, String pw, LoginCommunicationListener listener) {
    view.showIDError("");
    view.showPWError("");
    new LoginNetworking().doLogin(id, pw);
    listener.loginComplete();
  }

  /*
  private void validate() {
    Resources res = MyApplication.getInstance().getResources();
    LoginValidation.Validate2Result validate2Result = LoginValidation.validate2(id, pw, res);
    String msg = validate2Result.getMessage();
    switch (validate2Result.getErrorType()) {
      case ID:
        view.showIDError(msg);
        break;
      case PW:
        view.showPWError(msg);
        break;
      case PASS:
        view.hideKeyboard();
        listener.startMain();
        break;
    }
    Timber.i(validate2Result.toString());
  }
  */
}
