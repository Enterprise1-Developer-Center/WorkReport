package kr.co.e1.workreport.settings;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 30
 */

public interface SettingsPresenter {

  void onCreated(Bundle savedInstanceState);

  interface View {

    void showSettingsFragment();
  }
}
