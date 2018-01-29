package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddHolidayDialogPresenter {

  void onDetach();

  void onAddClick(String date, String name);

  void onHolidayEditTextClick(String date);

  void onHolidayNameEditTextClick(String name);

  interface View {

    void showDatePickerDialog(int year, int month, int dayOfMonth,
        DatePickerDialog.OnDateSetListener onDateSetListener);

    void showNameChoiceDialog(String[] items, int checkedItem, DialogInterface.OnClickListener onClickListener);

    void showMessage(@StringRes int resId);

    void showSuccessMessage(String msg);

    void showMessage(String msg);

    void setButtonEnabled(boolean enabled);

    void showDate(String holiday);

    void showHolidayName(String name);
  }
}
