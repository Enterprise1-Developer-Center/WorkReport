package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.interfaces.OnCompleteListener;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 29
 */

public class AddHolidayDialog extends BaseAlertDialogFragment
    implements AddHolidayDialogPresenter.View {
  @BindView(R.id.holiday_edittext) EditText holidayEditText;
  @BindView(R.id.holiday_name_edittext) EditText holidayNameEditText;
  @BindView(R.id.root_view) View rootView;
  @Inject AddHolidayDialogPresenter presenter;
  private @Setter @Accessors(chain = true) OnCompleteListener onCompleteListener;

  @Override protected boolean isDagger() {
    return true;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_holiday;
  }

  @Override protected int getTitle() {
    return R.string.holiday_add;
  }

  @Override protected boolean isDialogCancelable() {
    return true;
  }

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> presenter.onAddClick(holidayEditText.getText().toString().trim(),
        holidayNameEditText.getText().toString().trim());
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @DebugLog @OnClick(R.id.holiday_edittext) void onHolidayEditTextClick() {
    presenter.onHolidayEditTextClick(holidayEditText.getText().toString().trim());
  }

  @DebugLog @OnClick(R.id.holiday_name_edittext) void onHolidayNameEditTextClick() {
    presenter.onHolidayNameEditTextClick(holidayNameEditText.getText().toString().trim());
  }

  @Override public void showDatePickerDialog(int year, int month, int dayOfMonth,
      DatePickerDialog.OnDateSetListener onDateSetListener) {
    new DatePickerDialog(getContext(), onDateSetListener, year, month, dayOfMonth).show();
  }

  @Override public void showNameChoiceDialog(String[] items, int checkedItem,
      DialogInterface.OnClickListener onClickListener) {
    new AlertDialog.Builder(getContext()).setTitle(R.string.holiday_list)
        .setSingleChoiceItems(items, checkedItem, onClickListener)
        .setNegativeButton(android.R.string.cancel, null)
        .show();
  }

  @Override public void showSuccessMessage(String msg) {
    final Snackbar snackbar = Snackbar.make(rootView, msg, Snackbar.LENGTH_INDEFINITE);
    snackbar.setAction(android.R.string.ok, view -> {
      if (onCompleteListener != null) {
        onCompleteListener.onComplete();
      }
      dismiss();
    }).show();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void setButtonEnabled(boolean enabled) {
    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(enabled);
  }

  @Override public void showDate(String holiday) {
    holidayEditText.setText(holiday);
  }

  @Override public void showHolidayName(String name) {
    holidayNameEditText.setText(name);
  }
}
