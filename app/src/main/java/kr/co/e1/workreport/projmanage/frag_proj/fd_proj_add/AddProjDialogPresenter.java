package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddProjDialogPresenter {

  void onClick(int id);

  void onStartDateSet(int year, int month, int day);

  void onEndDateSet(int year, int month, int day);

  interface View {

    void showStartDatePickerDialog(int year, int month, int day);

    void showEndDatePickerDialog(int year, int month, int day);

    void showStartDate(String dateString);

    void showEndDate(String dateString);
  }
}
