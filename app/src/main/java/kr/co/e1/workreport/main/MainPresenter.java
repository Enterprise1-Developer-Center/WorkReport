package kr.co.e1.workreport.main;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 9. 25
 */

public interface MainPresenter {
  void onCreate(Bundle savedInstanceState);

  void onNavigationItemSelected(int itemId);

  interface View {
    void setListener();
  }
}
