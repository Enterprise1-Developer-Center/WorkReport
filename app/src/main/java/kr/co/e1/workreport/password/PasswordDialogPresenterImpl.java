package kr.co.e1.workreport.password;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialogPresenterImpl implements PasswordDialogPresenter {

  private PasswordDialogPresenter.View view;

  public PasswordDialogPresenterImpl(PasswordDialogPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override public void onOkClick() {

  }
}
