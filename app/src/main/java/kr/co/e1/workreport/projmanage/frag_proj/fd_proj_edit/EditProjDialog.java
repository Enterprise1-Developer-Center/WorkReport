package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit;

import android.os.Bundle;
import android.view.View;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class EditProjDialog extends BaseAlertDialogFragment {

  @Override protected boolean isNeutralButton() {
    return true;
  }

  @Override protected int getNeutraButtonText() {
    return R.string.del;
  }

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected int getPositiveButtonText() {
    return R.string.update;
  }

  @Override protected boolean isDagger() {
    return false;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_project;
  }

  @Override protected int getTitle() {
    return R.string.edit_project;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      dismiss();
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      dismiss();
    };
  }

  @Override protected View.OnClickListener onNeutraClickListener() {
    return view -> {
      dismiss();
    };
  }
}
