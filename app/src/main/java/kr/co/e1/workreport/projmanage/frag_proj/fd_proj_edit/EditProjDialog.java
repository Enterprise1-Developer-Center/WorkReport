package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class EditProjDialog extends BaseAlertDialogFragment
    implements EditProjDialogPresenter.View {

  @BindView(R.id.proj_code_edittext) EditText projCodeEdittext;
  @BindView(R.id.proj_name_edittext) EditText projNameEdittext;
  @BindView(R.id.start_date_edittext) EditText startDateEdittext;
  @BindView(R.id.end_date_edittext) EditText endDateEdittext;
  @BindView(R.id.dept_cd_edittext) EditText deptCdEdittext;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) FrameLayout rootView;

  @Inject EditProjDialogPresenter presenter;

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
    Timber.d("presenter = " + presenter);
    presenter.onActivityCreate();
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_project;
  }

  @Override protected int getTitle() {
    return R.string.edit_project;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      presenter.onEditClick();
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      dismiss();
    };
  }

  @Override protected View.OnClickListener onNeutraClickListener() {
    return view -> {
      presenter.onDelClick();
    };
  }

  @Override public void showStartDatePickerDialog(int year, int month, int day) {

  }

  @Override public void showEndDatePickerDialog(int year, int month, int day) {

  }

  @Override public void showStartDate(String dateString) {

  }

  @Override public void showEndDate(String dateString) {

  }

  @Override public void showMessage(int resId) {

  }

  @Override public void showDeptCodeListDialog(String[] items) {

  }

  @Override public void showDeptName(String dept) {

  }

  @Override public void showSuccessMessage(String msg) {

  }

  @Override public void showMessage(String msg) {

  }

  @Override public void setButtonEnabled(boolean enabled) {
    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(enabled);
    alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL).setEnabled(enabled);
  }

  @Override public void disableProjectCode() {
    projCodeEdittext.setEnabled(false);
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}
