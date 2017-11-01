package kr.co.e1.workreport.report;

import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 10. 19
 */

public interface ReportFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onClick(int id);

  void onReportDateSet(int y, int m, int dayOfMonth);

  void onStartTimeSet(int hourOfDay, int minute);

  void onEndTimeSet(int hourOfDay, int minute);

  interface View {

    void showReportDatePickerDialog();

    void setReportDate(String date);

    void setListener();

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
