package kr.co.e1.workreport.password;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 30
 */

public interface PasswordDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onOkClick();

  interface View {

  }
}
