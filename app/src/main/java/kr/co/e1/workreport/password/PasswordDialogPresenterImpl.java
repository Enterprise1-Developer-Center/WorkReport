package kr.co.e1.workreport.password;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialogPresenterImpl implements PasswordDialogPresenter {

  private PasswordDialogPresenter.View view;

  public PasswordDialogPresenterImpl(PasswordDialogPresenter.View view) {
    this.view = view;
  }
}
