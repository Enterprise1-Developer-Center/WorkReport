package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import java.util.List;
import kr.co.e1.workreport.common.model.DetailWork;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddEmpDialogPresenter {

  void onDetach();

  void onAddClick(String projCode, String projName, String startDate, String endDate,
      String deptCd);

  void onStartDateEditTextClick(String startDate);

  void onEndDateEditTextClick(String endDate);

  void onUserTypeEditTextClick(String deptName);

  void onUserNameEditTextClick(String userName);

  void onProjNameEditTextClick(String projName);

  void onClassEditTextClick(String mclsCode);

  interface View {

    void showStartDatePickerDialog(int year, int month, int dayOfMonth,
        DatePickerDialog.OnDateSetListener onDateSetListener);

    void showEndDatePickerDialog(int year, int month, int dayOfMonth,
        DatePickerDialog.OnDateSetListener onDateSetListener);

    void showStartDate(String dateString);

    void showEndDate(String dateString);

    void showMessage(@StringRes int resId);

    void showSuccessMessage(String msg);

    void showMessage(String msg);

    void setButtonEnabled(boolean enabled);

    void showUserChoiceDialog(String[] names, int checkedItem,
        DialogInterface.OnClickListener onClickListener);

    void showUserName(String userName);

    void showProjNamesChoiceDialog(String[] projectNames, int checkedItem,
        DialogInterface.OnClickListener onClickListener);

    void showProjName(String projName);

    void showUserTypeChoiceDialog(String[] names, int checkedItem,
        DialogInterface.OnClickListener onClickListener);

    void showUserType(String userTypeName);

    void showClassChoiceDialog(List<DetailWork> items, int checkedItem,
        OnClassItemClickListener onClassItemClickListener);

    void showClassCode(String mcls_cd);
  }
}
