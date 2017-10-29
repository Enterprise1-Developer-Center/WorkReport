package kr.co.e1.workreport.project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialog extends BaseAlertDialogFragment {

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return android.R.layout.select_dialog_singlechoice;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.project_name;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return null;
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }
}
