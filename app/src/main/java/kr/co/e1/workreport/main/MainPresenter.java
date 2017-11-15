package kr.co.e1.workreport.main;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.StringRes;
import java.util.List;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 9. 25
 */

public interface MainPresenter {
  void onCreate(Bundle savedInstanceState);

  void onNavigationItemSelected(int itemId);

  void onBackPressed(boolean isDrawerOpen);

  void onActivityCreate(Bundle savedInstanceState);

  void onSaveClick(List<ReportEntry> items);

  void onItemClick(ReportEntry item);

  void onDetailWorkDialogClick(ClassificationCode o, String work);

  void onProjectDialogClick(Project o);

  void onDestroy();

  void onLoginSuccess(String date);

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

    void showDatePickerDialog(int year, int month, int day,
        DatePickerDialog.OnDateSetListener listener);

    void showProgress();

    void hideProgress();

    void disableSaveButton();

    void enableSaveButton();

    void showClassificationDialog(String code, String work);

    void showProjectChoiceDialog(String code);

    void showMessage(@StringRes int resId);

    void setRecyclerView();

    void refresh();

    void refresh(int position);

    void showTimePickerDialog(int hour, int minute, TimePickerDialog.OnTimeSetListener listener);

    void showMessage(String msg);
  }
}
