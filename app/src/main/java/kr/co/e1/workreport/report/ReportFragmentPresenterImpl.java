package kr.co.e1.workreport.report;

import android.os.Bundle;
import android.os.Handler;
import hugo.weaving.DebugLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 10. 19
 */

public class ReportFragmentPresenterImpl implements ReportFragmentPresenter {

  private ReportFragmentPresenter.View view;

  @Inject ReportFragmentPresenterImpl(ReportFragmentPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setListener();
    view.setReportDate("2017-01-31 (목)");
    view.setGroup("BS");
    view.setPerson("오재호");
    view.setCode("42/개인학습");
    view.setProject("현대오토넷 오토시스템");
    view.setStartTime("19:00");
    view.setEndTime("23:00");
    view.setWorkTime("04:00");
    view.setLastEditDateTime("2017-10-23 (수) 14:12");
  }

  @Override public void onClick(int id) {
    switch (id) {
      case R.id.date_container:
        view.showReportDatePickerDialog();
        break;
      case R.id.start_time_container:
        view.showStartTimePickerDialog();
        break;
      case R.id.end_time_container:
        view.showEndTimePickerDialog();
        break;
      case R.id.code_container:
        break;
      case R.id.project_container:
        break;
      case R.id.save_button:
        view.showProgress();
        view.disableSaveButton();
        testPost();
        break;
    }
  }

  private void testPost() {
    new Handler().postDelayed(() -> {
      view.hideProgress();
      view.enableSaveButton();
    }, 2000);
  }

  @Override public void onRefresh() {
    testPost();
  }

  @DebugLog @Override public void onReportDateSet(int year, int month, int dayOfMonth) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    Date d = new Date(calendar.getTimeInMillis());
    String reportDate = dateFormat.format(d);
    view.setReportDate(reportDate);
  }

  @DebugLog @Override public void onStartTimeSet(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
    Date date = new Date(calendar.getTimeInMillis());

    String startTime = new SimpleDateFormat("HH:mm", Locale.KOREA).format(date);
    view.setStartTime(startTime);
  }

  @DebugLog @Override public void onEndTimeSet(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
    Date date = new Date(calendar.getTimeInMillis());

    String endTime = new SimpleDateFormat("HH:mm", Locale.KOREA).format(date);
    view.setEndTime(endTime);
  }
}
