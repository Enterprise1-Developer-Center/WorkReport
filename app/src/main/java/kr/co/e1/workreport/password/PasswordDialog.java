package kr.co.e1.workreport.password;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialog extends BaseAlertDialogFragment
    implements PasswordDialogPresenter.View {

  @Inject PasswordDialogPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override public void setListener() {
  }

  @Override public void showSnackBar(int resId) {
    Snackbar.make(contentView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showSnackBar(String msg) {
    Snackbar.make(contentView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_password;
  }

  @Override protected ViewGroup getInflateRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.empty_text;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      presenter.onPositiveClick();
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      dismiss();
    };
  }

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @BindView(R.id.now_edit_text) TextInputEditText nowTextInputEditText;
  @BindView(R.id.new_edit_text) TextInputEditText newTextInputEditText;
  @BindView(R.id.new_confirm_edit_text) TextInputEditText newConfirmTextInputEditText;

  @Override public void clear() {
    nowTextInputEditText.setText("");
    newTextInputEditText.setText("");
    newConfirmTextInputEditText.setText("");
  }

  @BindView(R.id.progress_bar) ProgressBar progressBar;

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }
}
