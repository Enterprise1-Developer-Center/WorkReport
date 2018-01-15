package kr.co.e1.workreport.projmanage.frag_proj.fd_proj;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class AddProjDialog extends BaseAlertDialogFragment {
  @Override protected boolean isNegativeButton() {
    return false;
  }

  @Override protected boolean isPositiveButton() {
    return false;
  }

  @Override protected boolean isDagger() {
    return false;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return 0;
  }

  @Override protected ViewGroup getInflateRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return 0;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return null;
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return null;
  }
}
