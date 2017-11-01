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

    void setDate(String date);

    void showProgress();

    void hideProgress();

    void setStartTime(String startTime);

    void setEndTime(String endTime);

    void setGroup(String group);

    void setPerson(String person);

    void setCode(String code);

    void setProject(String project);

    void setLastEditDateTime(String lastEditDateTime);

    void setWorkTime(String workTime);

  }
}
