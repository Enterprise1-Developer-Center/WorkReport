package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit;

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
import kr.co.e1.workreport.framework.interfaces.OnCompleteListener;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class EditProjDialog extends BaseAlertDialogFragment
    implements EditProjDialogPresenter.View {

  @BindView(R.id.proj_code_edittext) EditText projCodeEdittext;
  @BindView(R.id.proj_name_edittext) EditText projNameEdittext;
  @BindView(R.id.start_date_edittext) EditText startDateEdittext;
  @BindView(R.id.end_date_edittext) EditText endDateEdittext;
  @BindView(R.id.dept_name_edittext) EditText deptNameEdittext;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) FrameLayout rootView;

  @Inject EditProjDialogPresenter presenter;
  @Accessors(chain = true) @Setter private Project project;
  @Accessors(chain = true) @Setter private String deptName;
  @Accessors(chain = true) @Setter private OnCompleteListener onCompleteListener;

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
    return true;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(project, deptName);
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_project;
  }

  @Override protected int getTitle() {
    return R.string.edit_project;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      String projCode = projCodeEdittext.getText().toString().trim();
      String projName = projNameEdittext.getText().toString().trim();
      String startDate = startDateEdittext.getText().toString().trim();
      String endDate = endDateEdittext.getText().toString().trim();
      String deptCd = deptNameEdittext.getText().toString().trim();
      presenter.onEditClick(projCode, projName, startDate, endDate, deptCd);
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @Override protected View.OnClickListener onNeutraClickListener() {
    return view -> presenter.onDelClick(projCodeEdittext.getText().toString().trim());
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

  @Override public void showDeptCodeListDialog(String[] items, int checkedItem) {
    new AlertDialog.Builder(getActivity()).setSingleChoiceItems(items, checkedItem,
        (dialogInterface, position) -> {
          presenter.onDeptsItemClick(items[position]);
          dialogInterface.dismiss();
        }).show();
  }

  @Override public void showDeptName(String dept) {
    deptNameEdittext.setText(deptName);
  }

  @Override public void showDeptName() {
    deptNameEdittext.setText(deptName);
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
    alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL).setEnabled(enabled);
  }

  @Override public void disableProjectCode() {
    projCodeEdittext.setEnabled(false);
  }

  @Override public void showProject(Project project) {
    startDateEdittext.setText(project.getProj_sdate());
    endDateEdittext.setText(project.getProj_edate());
    deptNameEdittext.setText(deptName);
  }

  @Override public void showProjectCode(String proj_cd) {
    projCodeEdittext.setText(proj_cd);
  }

  @Override public void showProjectName(String proj_nm) {
    projNameEdittext.setText(proj_nm);
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }

  @OnClick(R.id.start_date_edittext) void onStartDateEditTextClick() {
    presenter.onStartDateEditTextClick(project);
  }

  @OnClick(R.id.end_date_edittext) void onEndDateEditTextClick() {
    presenter.onEndDateEditTextClick(project);
  }

  @OnClick(R.id.dept_name_edittext) void onDeptNameEditTextClick() {
    presenter.onDeptNameEditText(deptNameEdittext.getText().toString().trim());
  }
}
