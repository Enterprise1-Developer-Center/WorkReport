package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import android.content.DialogInterface;
import android.support.annotation.StringRes;
import java.util.List;
import kr.co.e1.workreport.common.model.DetailWork;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddEmpDialogPresenter {

  void onStartDateSet(int year, int month, int day);

  void onEndDateSet(int year, int month, int day);

  void onDetach();

  void onAddClick(String projCode, String projName, String startDate, String endDate,
      String deptCd);

  void onStartDateEditTextClick(String startDate);

  void onEndDateEditTextClick(String endDate);

  void onUserTypeEditTextClick(String deptName);

  void onUserNameEditTextClick(String userName);

  void onProjNameEditTextClick(String projName);

  void onUserNameOfDialogListClick(DialogInterface dialog, String userName);

  void onProjNameOfDialogListClick(DialogInterface dialog, String projectName);

  void onUserTypeOfDialogListClick(DialogInterface dialog, String userTypeName);

  void onClassEditTextClick(String mclsCode);

  void onClassItemClick(DetailWork item, DialogInterface dialog);

  interface View {

    void showStartDatePickerDialog(int year, int month, int day);

    void showEndDatePickerDialog(int year, int month, int day);

    void showStartDate(String dateString);

    void showEndDate(String dateString);

    void showMessage(@StringRes int resId);

    void showSuccessMessage(String msg);

    void showMessage(String msg);

    void setButtonEnabled(boolean enabled);

    void showUserChoiceDialog(String[] names, int checkedItem);

    void showUserName(String userName);

    void showProjNamesChoiceDialog(String[] projectNames, int checkedItem);

    void showProjName(String projName);

    void showUserTypeChoiceDialog(String[] names, int checkedItem);

    void showUserType(String userTypeName);

    void showClassChoiceDialog(List<DetailWork> items, int checkedItem);

    void showClassCode(String mcls_cd);
  }
}
