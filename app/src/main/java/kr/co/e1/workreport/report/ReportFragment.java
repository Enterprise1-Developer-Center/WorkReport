package kr.co.e1.workreport.report;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import java.util.Calendar;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.ClassificationDialog;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.project.ProjectDialog;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class ReportFragment extends BaseFragment implements ReportFragmentPresenter.View {
  @Inject ReportFragmentPresenter presenter;

  @BindView(R.id.save_button) ImageView saveButton;
  @BindView(R.id.progressbar) ProgressBar progressBar;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_report;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean isDagger() {
    return true;
  }

  public static ReportFragment newInstance(Bundle args) {
    ReportFragment f = new ReportFragment();
    f.setArguments(args);
    return f;
  }

  @OnClick({
      R.id.date_container, R.id.start_time_container, R.id.end_time_container, R.id.code_container,
      R.id.project_container, R.id.save_button
  }) public void onClick(View view) {
    presenter.onClick(view.getId());
  }

  @Override public void showReportDatePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int cYear = calendar.get(Calendar.YEAR);
    int cMonth = calendar.get(Calendar.MONTH);
    int cDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    Timber.d("year = " + cYear + ", month = " + cMonth + ", day = " + cDayOfMonth);

    new DatePickerDialog(getContext(), (datePicker, year, month, dayOfMonth) -> {
      presenter.onReportDateSet(year, month, dayOfMonth);
    }, cYear, cMonth, cDayOfMonth).show();
  }

  @BindView(R.id.date_textview) TextView dateTextView;

  @Override public void setReportDate(String date) {
    dateTextView.setText(date);
  }

  @Override public void setListener() {
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void enableSaveButton() {
    saveButton.setEnabled(true);
    saveButton.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary));
  }

  @Override public void disableSaveButton() {
    saveButton.setEnabled(false);
    saveButton.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorIndigo_100));
  }

  @Override public void showStartTimePickerDialog() {

    Calendar calendar = Calendar.getInstance();
    int cHourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    int cMinute = calendar.get(Calendar.MINUTE);

    new TimePickerDialog(getContext(), (view, hourOfDay, minute) -> {
      presenter.onStartTimeSet(hourOfDay, minute);
    }, cHourOfDay, cMinute, true).show();
  }

  @Override public void showEndTimePickerDialog() {

    Calendar calendar = Calendar.getInstance();
    int cHourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    int cMinute = calendar.get(Calendar.MINUTE);

    new TimePickerDialog(getContext(), (view, hourOfDay, minute) -> {
      presenter.onEndTimeSet(hourOfDay, minute);
    }, cHourOfDay, cMinute, true).show();
  }

  @BindView(R.id.start_time_textview) TextView startTimeTextView;

  @DebugLog @Override public void setStartTime(String startTime) {
    startTimeTextView.setText(startTime);
  }

  @BindView(R.id.end_time_textview) TextView endTimeTextView;

  @DebugLog @Override public void setEndTime(String endTime) {
    endTimeTextView.setText(endTime);
  }

  @BindView(R.id.group_textview) TextView groupTextView;

  @Override public void setGroup(String group) {
    groupTextView.setText(group);
  }

  @BindView(R.id.person_textview) TextView personTextView;

  @Override public void setPerson(String person) {
    personTextView.setText(person);
  }

  @BindView(R.id.code_textview) TextView codeTextView;

  @Override public void setCode(String code) {
    codeTextView.setText(code);
  }

  @BindView(R.id.project_textview) TextView projectTextView;

  @Override public void setProject(String project) {
    projectTextView.setText(project);
  }

  @BindView(R.id.last_edit_textview) TextView lastEditTextView;

  @Override public void setLastEditDateTime(String lastEditDateTime) {
    lastEditTextView.setText(lastEditDateTime);
  }

  @Nullable @BindView(R.id.work_time_textview) TextView workTimeTextView;

  @Override public void setWorkTime(String workTime) {
    workTimeTextView.setText(workTime);
  }

  @Override public void showCodeDialogFragment() {
    new ClassificationDialog().setOnDialogClickListener(
        o -> codeTextView.setText(o.getString("code") + " / " + o.getString("work")))
        .show(getFragmentManager(), ClassificationDialog.class.getSimpleName());
  }

  @Override public void showProjectChoiceDialog() {
    new ProjectDialog().setOnDialogClickListener(o -> projectTextView.setText(o.getString("name")))
        .show(getFragmentManager(), ProjectDialog.class.getSimpleName());
  }
  @BindView(R.id.root_view) View rootView;
  @Override public void showSnakeBar(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }
}
