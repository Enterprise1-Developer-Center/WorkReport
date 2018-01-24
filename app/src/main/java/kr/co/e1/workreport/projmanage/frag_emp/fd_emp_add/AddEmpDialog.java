package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.jakewharton.rxbinding2.view.RxView;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.interfaces.OnCompleteListener;
import kr.co.e1.workreport.projmanage.frag_emp.fd_class.ClassDialog;
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
  @BindView(R.id.user_type_edittext) EditText userTypeEdittext;
  @BindView(R.id.class_edittext) EditText classEditText;
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

    RxView.clicks(classEditText)
        .throttleFirst(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(o -> presenter.onClassEditTextClick(classEditText.getText().toString().trim()));
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_emp;
  }

  @Override protected int getTitle() {
    return R.string.add_emp;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> presenter.onAddClick();
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @DebugLog @Override public void showStartDatePickerDialog(int year, int month, int day,
      DatePickerDialog.OnDateSetListener onDateSetListener) {
    new DatePickerDialog(getContext(), onDateSetListener, year, month, day).show();
  }

  @DebugLog @Override public void showEndDatePickerDialog(int year, int month, int dayOfMonth,
      DatePickerDialog.OnDateSetListener onDateSetListener) {
    new DatePickerDialog(getContext(), onDateSetListener, year, month, dayOfMonth).show();
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

  @Override public void showUserChoiceDialog(final String[] names, int checkedItem,
      DialogInterface.OnClickListener onClickListener) {
    new AlertDialog.Builder(getContext()).setSingleChoiceItems(names, checkedItem, onClickListener)
        .setNegativeButton(android.R.string.cancel, null)
        .show();
  }

  @Override public void showProjNamesChoiceDialog(String[] projectNames, int checkedItem,
      DialogInterface.OnClickListener onClickListener) {
    new AlertDialog.Builder(getContext()).setSingleChoiceItems(projectNames, checkedItem,
        onClickListener).setNegativeButton(android.R.string.cancel, null).show();
  }

  @Override public void showUserTypeChoiceDialog(String[] names, int checkedItem,
      DialogInterface.OnClickListener onClickListener) {
    new AlertDialog.Builder(getContext()).setSingleChoiceItems(names, checkedItem, onClickListener)
        .setNegativeButton(android.R.string.cancel, null)
        .show();
  }

  @Override public void showClassChoiceDialog(List<DetailWork> items, int checkedItem,
      OnClassItemClickListener onClassItemClickListener) {
    new ClassDialog().setItems(items)
        .setCheckedItem(checkedItem)
        .setOnItemClickListener(onClassItemClickListener)
        .show(getFragmentManager(), ClassDialog.class.getSimpleName());
  }

  @Override public void showProjName(String projName) {
    projNameEdittext.setText(projName);
  }

  @Override public void showUserName(String userName) {
    userNameEdittext.setText(userName);
  }

  @Override public void showUserType(String userTypeName) {
    userTypeEdittext.setText(userTypeName);
  }

  @Override public void showClassCode(String mcls_cd) {
    classEditText.setText(mcls_cd);
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

  @OnClick(R.id.user_type_edittext) void onEmpTypeEditTextClick() {
    presenter.onUserTypeEditTextClick(userTypeEdittext.getText().toString().trim());
  }

  /*
  @OnClick(R.id.class_edittext) void onClassEditTextClick() {
    presenter.onClassEditTextClick(classEditText.getText().toString().trim());
  }
  */
}