package kr.co.e1.workreport.teamreportdialog;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 11. 1
 */

public interface TeamReportDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onClick(int id);

  void onDateSet(int year, int month, int dayOfMonth);

  interface View {

    void hideSaveButton();

    void showDatePickerDialog();

    void showDate(String date);

    void showProgress();

    void hideProgress();

    void showStartTime(String startTime);

    void showEndTime(String endTime);

    void showGroup(String group);

    void showPerson(String person);

    void showCode(String code);

    void showProject(String project);

    void showLastEditDateTime(String lastEditDateTime);

    void showWorkTime(String workTime);

  }
}
