package kr.co.e1.workreport.main.dialog_login;

import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 9. 27
 */

public interface LoginFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onPositiveClick(String id, String pw);

  void onDetach();

  interface View {

    void setEditTextFilter();

    void showIDError(String msg);

    void showPWError(String msg);

    void hideKeyboard();

    void dismiss();

    void showProgress();

    void hideProgress();

    void showMessage(String msg);
    void showMessage(@StringRes int resId);

    void setButtonEnabled(boolean enable);
  }
}
