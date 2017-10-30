package kr.co.e1.workreport.password;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialog extends BaseAlertDialogFragment implements PasswordDialogPresenter.View{
  @Override protected void onActivityCreate(Bundle savedInstanceState) {

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
    return null;
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }
}
