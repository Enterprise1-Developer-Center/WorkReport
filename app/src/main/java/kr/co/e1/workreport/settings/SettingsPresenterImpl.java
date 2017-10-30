package kr.co.e1.workreport.settings;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class SettingsPresenterImpl implements SettingsPresenter {

  private SettingsPresenter.View view;

  SettingsPresenterImpl(SettingsPresenter.View view) {
    this.view = view;
  }

  @Override public void onCreated(Bundle savedInstanceState) {

  }
}