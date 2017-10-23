package kr.co.e1.workreport.report;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import java.util.Calendar;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class ReportFragment extends BaseFragment implements ReportFragmentPresenter.View {

  @Inject ReportFragmentPresenter presenter;

  @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
  @BindView(R.id.save_button) FloatingActionButton saveButton;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_report;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
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
    swipeRefresh.setOnRefreshListener(() -> {
    });
  }

  @Override public void showProgress() {
    swipeRefresh.setRefreshing(true);
  }

  @Override public void hideProgress() {
    swipeRefresh.setRefreshing(false);
  }

  @Override public void enableSaveButton() {
    saveButton.setEnabled(true);
    saveButton.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary));
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

  @Override public void disableSaveButton() {
    saveButton.setEnabled(false);
    saveButton.setColorFilter(ContextCompat.getColor(getContext(), android.R.color.white));
  }
}
