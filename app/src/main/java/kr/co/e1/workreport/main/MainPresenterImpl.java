package kr.co.e1.workreport.main;

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
 * Created by jaeho on 2017. 9. 25
 */

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;

  @Inject public MainPresenterImpl(MainPresenter.View view) {
    this.view = view;
    view.changeTheme();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    view.showLoginFragment(savedInstanceState);
  }

  @Override public void onNavigationItemSelected(int itemId) {
    if (itemId == R.id.nav_statistics) {
      view.navigateToStatistics();
    } else if (itemId == R.id.nav_team_report) {
      view.navigateToTeamReport();
    } else if (itemId == R.id.nav_password) {
      view.showPasswordChangeDialog();
    } else if (itemId == R.id.nav_review) {
      view.navigateToReview();
    }
  }

  @Override public void loginComplete() {
    //view.showReportFragment();
    view.showMessage(R.string.login_complete);
    view.setListener();
    view.showReportDate("2017-01-31 (목)");
    view.showGroup("BS");
    view.showPerson("오재호");
    view.showCode("42/개인학습");
    view.showProject("현대오토넷 오토시스템");
    view.showStartTime("19:00");
    view.showEndTime("23:00");
    view.showWorkTime("04:00");
    view.showLastEditDateTime("2017-10-23 (수) 14:12");
  }

  @Override public void onBackPressed(boolean isDrawerOpen) {
    if (isDrawerOpen) {
      view.closeDrawer();
    } else {
      view.finish();
    }
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {

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
        view.showCodeDialogFragment();
        break;
      case R.id.project_container:
        view.showProjectChoiceDialog();
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
      view.showMessage(R.string.save_completed);
    }, 2000);
  }

  @DebugLog @Override public void onReportDateSet(int year, int month, int dayOfMonth) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    Date d = new Date(calendar.getTimeInMillis());
    String reportDate = dateFormat.format(d);
    view.showReportDate(reportDate);
  }

  @DebugLog @Override public void onStartTimeSet(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
    Date date = new Date(calendar.getTimeInMillis());

    String startTime = new SimpleDateFormat("HH:mm", Locale.KOREA).format(date);
    view.showStartTime(startTime);
  }

  @DebugLog @Override public void onEndTimeSet(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
    Date date = new Date(calendar.getTimeInMillis());

    String endTime = new SimpleDateFormat("HH:mm", Locale.KOREA).format(date);
    view.showEndTime(endTime);
  }
}