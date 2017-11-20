package kr.co.e1.workreport.password;

import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 10. 30
 */

public interface PasswordDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onRefresh();

  void onPositiveClick(String nowPw, String newPw, String newPwConfirm);

  interface View {

    void dismiss();

    void clear();

    void showProgress();

    void hideProgress();

    void setListener();

    void showMessage(@StringRes int resId);

    void showMessage(String msg);

  }
}
