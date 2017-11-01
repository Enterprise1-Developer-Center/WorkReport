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

    void setReportDate(String date);

    void showProgress();

    void hideProgress();

    void disableSaveButton();

    void enableSaveButton();

    void showStartTimePickerDialog();

    void showEndTimePickerDialog();

    void setStartTime(String startTime);

    void setEndTime(String endTime);

    void setGroup(String group);

    void setPerson(String person);

    void setCode(String code);

    void setProject(String project);

    void setLastEditDateTime(String lastEditDateTime);

    void setWorkTime(String workTime);

    void showCodeDialogFragment();

    void showProjectChoiceDialog();

    void showSnakeBar(@StringRes int resId);
  }
}
