package kr.co.e1.workreport.login;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import javax.inject.Inject;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.framework.LoginValidation;
import kr.co.e1.workreport.main.LoginCommunicationListener;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 9. 27
 */

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

  LoginFragmentPresenter.View view;

  @Inject LoginFragmentPresenterImpl(LoginFragmentPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    Log.d("OJH", "onActvityCreate");
    //view.setEditTextFilter();
  }

  @Override public void onLoginClick(String id, String pw, LoginCommunicationListener listener) {
    Resources res = MyApplication.getInstance().getResources();
    LoginValidation.Validate2Result validate2Result = LoginValidation.validate2(pw, id, res);
    Timber.i(validate2Result.toString());
  }
}
