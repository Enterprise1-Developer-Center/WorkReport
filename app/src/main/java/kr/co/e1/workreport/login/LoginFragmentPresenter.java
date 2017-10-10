package kr.co.e1.workreport.login;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 9. 27
 */

public interface LoginFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  interface View {

    void setEditTextFilter();
  }
}
