package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class AddProjDialog extends BaseAlertDialogFragment implements AddProjDialogPresenter.View {

  @BindView(R.id.proj_code_edittext) EditText projCodeEdittext;
  @BindView(R.id.proj_name_edittext) EditText projNameEdittext;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) FrameLayout rootView;
  @BindView(R.id.start_date_edittext) EditText startDateEdittext;
  @BindView(R.id.end_date_edittext) EditText endDateEdittext;
  @BindView(R.id.dept_cd_edittext) EditText deptCdEdittext;

  @Inject AddProjDialogPresenter presenter;

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
    return R.layout.dialog_add_project;
  }

  @Override protected int getTitle() {
    return R.string.add_project;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return new View.OnClickListener() {
      @Override public void onClick(View view) {

        String projCode = projCodeEdittext.getText().toString().trim();
        String projName = projNameEdittext.getText().toString().trim();
        String startDate = startDateEdittext.getText().toString().trim();
        String endDate = endDateEdittext.getText().toString().trim();
        String deptCd = deptCdEdittext.getText().toString().trim();
        presenter.onAddClick(projCode, projName, startDate, endDate, deptCd);
      }
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @OnClick({ R.id.start_date_edittext, R.id.end_date_edittext, R.id.dept_cd_edittext })
  void onClick(View view) {
    presenter.onClick(view.getId());
  }

  @Override public void showStartDatePickerDialog(int $year, int $month, int $day) {
    new DatePickerDialog(getContext(),
        (datePicker, year, month, day) -> presenter.onStartDateSet(year, month, day), $year, $month,
        $day).show();
  }

  @Override public void showEndDatePickerDialog(int $year, int $month, int $day) {
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

  @Override public void showDeptCodeListDialog(String[] items) {
    new AlertDialog.Builder(getActivity()).setSingleChoiceItems(items, 0,
        (dialogInterface, position) -> {
          presenter.onDeptsItemClick(items[position]);
          dialogInterface.dismiss();
        }).show();
  }

  @Override public void showDeptName(String dept) {
    deptCdEdittext.setText(dept);
  }

  @Override public void showSuccessMessage(String msg) {
    final Snackbar snackbar = Snackbar.make(rootView, msg, Snackbar.LENGTH_INDEFINITE);
    snackbar.setAction(android.R.string.ok, view -> {
      dismiss();
    }).show();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void setButtonEnabled(boolean enabled) {
    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(enabled);
  }

  @Override public void onDetach() {
    presenter.onDetach();
    super.onDetach();
  }
}