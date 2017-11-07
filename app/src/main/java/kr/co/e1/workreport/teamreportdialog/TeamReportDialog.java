package kr.co.e1.workreport.teamreportdialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import java.util.Calendar;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 11. 1
 */
public class TeamReportDialog extends BaseAlertDialogFragment
    implements TeamReportDialogPresenter.View {
  @BindView(R.id.save_button) ImageView saveButton;

  @Override protected boolean isNegativeButton() {
    return false;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Inject TeamReportDialogPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return R.layout.fragment_report;
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
      dismiss();
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {

    };
  }

  @Override public void hideSaveButton() {
    saveButton.setVisibility(View.GONE);
  }

  @Override public void showDatePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int cYear = calendar.get(Calendar.YEAR);
    int cMonth = calendar.get(Calendar.MONTH);
    int cDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    Timber.d("year = " + cYear + ", month = " + cMonth + ", day = " + cDayOfMonth);

    new DatePickerDialog(getContext(), (datePicker, year, month, dayOfMonth) -> {
      presenter.onDateSet(year, month, dayOfMonth);
    }, cYear, cMonth, cDayOfMonth).show();
  }

  @BindView(R.id.date_textview) TextView dateTextView;

  @Override public void showDate(String date) {
    dateTextView.setText(date);
  }

  @BindView(R.id.progress_bar) ProgressBar progressBar;

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @BindView(R.id.start_time_textview) TextView startTimeTextview;

  @Override public void showStartTime(String startTime) {
    startTimeTextview.setText(startTime);
  }

  @BindView(R.id.end_time_textview) TextView endTimeTextview;

  @Override public void showEndTime(String endTime) {
    endTimeTextview.setText(endTime);
  }

  @BindView(R.id.group_textview) TextView groupTextView;

  @Override public void showGroup(String group) {
    groupTextView.setText(group);
  }

  @BindView(R.id.person_textview) TextView personTextView;

  @Override public void showPerson(String person) {
    personTextView.setText(person);
  }

  @BindView(R.id.code_textview) TextView codeTextview;

  @Override public void showCode(String code) {
    codeTextview.setText(code);
  }

  @BindView(R.id.project_textview) TextView projectTextView;

  @Override public void showProject(String project) {
    projectTextView.setText(project);
  }

  @BindView(R.id.last_edit_textview) TextView lastEditTextView;

  @Override public void showLastEditDateTime(String lastEditDateTime) {
    lastEditTextView.setText(lastEditDateTime);
  }

  @BindView(R.id.work_time_textview) TextView workTimeTextView;

  @Override public void showWorkTime(String workTime) {
    workTimeTextView.setText(workTime);
  }

  @OnClick(R.id.date_container) void onClick(View view) {
    presenter.onClick(view.getId());
  }
}
