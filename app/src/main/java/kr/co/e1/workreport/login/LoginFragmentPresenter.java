package kr.co.e1.workreport.login;

import android.os.Bundle;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 27
 */

public interface LoginFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onLoginClick(String id, String pw, LoginCommunicationListener listener);

  interface View {

    void setEditTextFilter();

    void showIDError(String msg);

    void showPWError(String msg);

    void hideKeyboard();
  }
}
