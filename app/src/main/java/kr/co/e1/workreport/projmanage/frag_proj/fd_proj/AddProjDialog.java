package kr.co.e1.workreport.projmanage.frag_proj.fd_proj;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class AddProjDialog extends BaseAlertDialogFragment {
  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
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
    return R.layout.dialog_add_project;
  }

  @Override protected ViewGroup getInflateRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return true;
  }

  @Override protected int getTitle() {
    return R.string.add_project;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return new View.OnClickListener() {
      @Override public void onClick(View view) {

      }
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return new View.OnClickListener() {
      @Override public void onClick(View view) {

      }
    };
  }
}
