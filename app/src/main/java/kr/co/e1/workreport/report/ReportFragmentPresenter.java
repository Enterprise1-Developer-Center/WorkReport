package kr.co.e1.workreport.report;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 19
 */

public interface ReportFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onClick(int id);

  void onReportDateSet(int y, int m, int dayOfMonth);

  interface View {

    void showReportDatePickerDialog();

    void showDate(String date);

    void setListener();

    void showProgress();

    void hideProgress();

    void disableSaveButton();

    void enableSaveButton();
  }
}
