package kr.co.e1.workreport.password;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 30
 */

public interface PasswordDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onOkClick();

  void onRefresh();

  interface View {

    void dismiss();

    void clear();

    void showProgress();

    void hideProgress();

    void setListener();
  }
}
