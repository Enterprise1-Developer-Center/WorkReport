package kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday;

import android.content.DialogInterface;
import android.support.annotation.StringRes;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface EditHolidayDialogPresenter {

  void onDetach();

  void onHolidayNameEditTextClick(String name);

  void onEditClick(String date, String name);

  void onActivityCreate(Holiday holiday);

  void onDelClick(String date);

  interface View {

    void showNameChoiceDialog(String[] items, int checkedItem,
        DialogInterface.OnClickListener onClickListener);

    void showMessage(@StringRes int resId);

    void showSuccessMessage(String msg);

    void showMessage(String msg);

    void setButtonEnabled(boolean enabled);

    void showDate(String holiday);

    void showHolidayName(String name);

    void disableLayout();
  }
}
