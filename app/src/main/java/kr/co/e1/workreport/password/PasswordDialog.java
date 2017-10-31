package kr.co.e1.workreport.password;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ViewGroup;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialog extends BaseAlertDialogFragment
    implements PasswordDialogPresenter.View {

  @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefreshLayout;
  @Inject PasswordDialogPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override public void setListener() {
    swipeRefreshLayout.setOnRefreshListener(() -> {
      presenter.onRefresh();
    });
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

  @Override public void onStart() {
    super.onStart();
    AlertDialog dialog = (AlertDialog) getDialog();
    if (dialog != null) {
      dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(view -> {
        presenter.onOkClick();
      });
    }
  }

  @BindView(R.id.now_edit_text) TextInputEditText nowTextInputEditText;
  @BindView(R.id.new_edit_text) TextInputEditText newTextInputEditText;
  @BindView(R.id.new_confirm_edit_text) TextInputEditText newConfirmTextInputEditText;

  @Override public void clear() {
    nowTextInputEditText.setText("");
    newTextInputEditText.setText("");
    newConfirmTextInputEditText.setText("");
  }

  @Override public void showProgress() {
    swipeRefreshLayout.setRefreshing(true);
  }

  @Override public void hideProgress() {
    swipeRefreshLayout.setRefreshing(false);
  }
}
