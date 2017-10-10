package kr.co.e1.workreport.login;

import android.os.Bundle;
import android.util.Log;
import javax.inject.Inject;

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
    view.setEditTextFilter();
  }
}
