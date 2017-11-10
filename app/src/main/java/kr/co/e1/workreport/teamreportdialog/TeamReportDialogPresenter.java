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

    void showDatePickerDialog();

    void showProgress();

    void hideProgress();

    void setRecyclerView();

    void refresh(int position);
  }
}
