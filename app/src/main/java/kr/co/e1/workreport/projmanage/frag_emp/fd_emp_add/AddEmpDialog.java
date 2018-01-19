package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.interfaces.OnCompleteListener;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class AddEmpDialog extends BaseAlertDialogFragment implements AddEmpDialogPresenter.View {

  @Inject AddEmpDialogPresenter presenter;
  @BindView(R.id.user_name_edittext) EditText userNameEdittext;
  @BindView(R.id.proj_name_edittext) EditText projNameEdittext;
  @BindView(R.id.start_date_edittext) EditText startDateEdittext;
  @BindView(R.id.end_date_edittext) EditText endDateEdittext;
  @BindView(R.id.emp_type_edittext) EditText empTypeEdittext;
  @BindView(R.id.root_view) FrameLayout rootView;

  private @Setter @Accessors(chain = true) OnCompleteListener onCompleteListener;

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_emp;
  }

  @Override protected int getTitle() {
    return R.string.add_emp;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      String projName = projNameEdittext.getText().toString().trim();
      String startDate = startDateEdittext.getText().toString().trim();
      String endDate = endDateEdittext.getText().toString().trim();
      String emlType = empTypeEdittext.getText().toString().trim();
      //presenter.onAddClick(projCode, projName, startDate, endDate, deptCd);
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @DebugLog @Override public void showStartDatePickerDialog(int $year, int $month, int $day) {
    new DatePickerDialog(getContext(),
        (datePicker, year, month, day) -> presenter.onStartDateSet(year, month, day), $year, $month,
        $day).show();
  }

  @DebugLog @Override public void showEndDatePickerDialog(int $year, int $month, int $day) {
    new DatePickerDialog(getContext(),
        (datePicker, year, month, day) -> presenter.onEndDateSet(year, month, day), $year, $month,
        $day).show();
  }

  @Override public void showStartDate(String dateString) {
    startDateEdittext.setText(dateString);
  }

  @Override public void showEndDate(String dateString) {
    endDateEdittext.setText(dateString);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showEmpsDialog(String[] items, int checkedItem) {
    new AlertDialog.Builder(getActivity()).setSingleChoiceItems(items, checkedItem,
        (dialogInterface, position) -> {
          presenter.onEmpsItemClick(items[position]);
          dialogInterface.dismiss();
        }).show();
  }

  @Override public void showEmp(String emp) {
    //deptNameEdittext.setText(dept);
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

  @Override public void setButtonEnabled(boolean enabled) {
    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(enabled);
  }

  @Override public void showUserChoiceDialog(List<User> items) {
    ArrayAdapter arrayAdapter =
        new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, items);
    new AlertDialog.Builder(getContext()).setSingleChoiceItems(arrayAdapter, 0, null).show();
  }

  @Override public void onDetach() {
    presenter.onDetach();
    super.onDetach();
  }

  @OnClick(R.id.user_name_edittext) void onUserNameEditTextClick() {
    presenter.onUserNameEditTextClick(userNameEdittext.getText().toString().trim());
  }

  @OnClick(R.id.proj_name_edittext) void onProjNameEditTextClick() {
    presenter.onProjNameEditTextClick(projNameEdittext.getText().toString().trim());
  }

  @OnClick(R.id.start_date_edittext) void onStartDateEditTextClick() {
    presenter.onStartDateEditTextClick(startDateEdittext.getText().toString().trim());
  }

  @OnClick(R.id.end_date_edittext) void onEndDateEditTextClick() {
    presenter.onEndDateEditTextClick(endDateEdittext.getText().toString().trim());
  }

  @OnClick(R.id.emp_type_edittext) void onEmpTypeEditTextClick() {
    presenter.onEmpTypeEditTextClick(empTypeEdittext.getText().toString().trim());
  }
}