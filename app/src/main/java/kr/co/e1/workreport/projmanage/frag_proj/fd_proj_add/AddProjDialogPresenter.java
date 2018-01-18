package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddProjDialogPresenter {

  void onStartDateSet(int year, int month, int day);

  void onEndDateSet(int year, int month, int day);

  void onDetach();

  void onDeptsItemClick(String dept);

  void onAddClick(String projCode, String projName, String startDate, String endDate, String deptCd);

  void onStartDateEditTextClick(String startDate);

  void onEndDateEditTextClick(String endDate);

  void onDeptNameEditText(String deptName);

  interface View {

    void showStartDatePickerDialog(int year, int month, int day);

    void showEndDatePickerDialog(int year, int month, int day);

    void showStartDate(String dateString);

    void showEndDate(String dateString);

    void showMessage(@StringRes int resId);

    void showDeptCodeListDialog(String[] items, int checkedItem);

    void showDeptName(String dept);

    void showSuccessMessage(String msg);

    void showMessage(String msg);

    void setButtonEnabled(boolean enabled);
  }
}
