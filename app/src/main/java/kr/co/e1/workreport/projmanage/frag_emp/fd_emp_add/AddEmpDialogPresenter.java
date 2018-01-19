package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import android.support.annotation.StringRes;
import java.util.List;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddEmpDialogPresenter {

  void onStartDateSet(int year, int month, int day);

  void onEndDateSet(int year, int month, int day);

  void onDetach();

  void onEmpsItemClick(String dept);

  void onAddClick(String projCode, String projName, String startDate, String endDate, String deptCd);

  void onStartDateEditTextClick(String startDate);

  void onEndDateEditTextClick(String endDate);

  void onEmpTypeEditTextClick(String deptName);

  void onUserNameEditTextClick(String userName);

  void onProjNameEditTextClick(String projName);

  interface View {

    void showStartDatePickerDialog(int year, int month, int day);

    void showEndDatePickerDialog(int year, int month, int day);

    void showStartDate(String dateString);

    void showEndDate(String dateString);

    void showMessage(@StringRes int resId);

    void showEmpsDialog(String[] items, int checkedItem);

    void showEmp(String dept);

    void showSuccessMessage(String msg);

    void showMessage(String msg);

    void setButtonEnabled(boolean enabled);

    void showUserChoiceDialog(List<User> items);
  }
}
