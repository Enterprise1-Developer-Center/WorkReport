package kr.co.e1.workreport.password;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialog extends BaseAlertDialogFragment implements PasswordDialogPresenter.View{
  @Inject PasswordDialogPresenter presenter;
  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return R.layout.dialog_password;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.change_pw;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialogInterface, int which) {
        presenter.onOkClick();
      }
    };
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }
}
