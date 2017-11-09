package kr.co.e1.workreport.main;

import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 9. 25
 */

public interface MainPresenter {
  void onCreate(Bundle savedInstanceState);

  void onNavigationItemSelected(int itemId);

  void loginComplete();

  void onBackPressed(boolean isDrawerOpen);

  void onActivityCreate(Bundle savedInstanceState);

  void onClick(int id);

  void onReportDateSet(int y, int m, int dayOfMonth);

  void onStartTimeSet(int hourOfDay, int minute);

  void onEndTimeSet(int hourOfDay, int minute);

  interface View {
    void setListener();

    void showLoginFragment(Bundle savedInstanceState);

    void showPasswordChangeDialog();

    void changeTheme();

    void closeDrawer();

    void finish();

    void navigateToStatistics();

    void navigateToTeamReport();

    void navigateToReview();

    void showReportDatePickerDialog();

    void showReportDate(String date);

    void showProgress();

    void hideProgress();

    void disableSaveButton();

    void enableSaveButton();

    void showStartTimePickerDialog();

    void showEndTimePickerDialog();

    void showStartTime(String startTime);

    void showEndTime(String endTime);

    void showGroup(String group);

    void showPerson(String person);

    void showCode(String code);

    void showProject(String project);

    void showLastEditDateTime(String lastEditDateTime);

    void showWorkTime(String workTime);

    void showCodeDialogFragment();

    void showProjectChoiceDialog();

    void showMessage(@StringRes int resId);
  }
}
