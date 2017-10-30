package kr.co.e1.workreport.password;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialog extends BaseAlertDialogFragment {
  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return 0;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return 0;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return null;
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }
}
