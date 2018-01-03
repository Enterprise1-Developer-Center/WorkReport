package kr.co.e1.workreport.teamreport.dialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.StringRes;
import kr.co.e1.workreport.common.model.ReportEntry;

/**
 * Created by jaeho on 2017. 11. 1
 */

public interface TeamReportDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onItemClick(ReportEntry item);

  void onDetach();

  interface View {

    void showDatePickerDialog(int year, int month, int day, DatePickerDialog.OnDateSetListener listener);

    void showProgress();

    void hideProgress();

    void setRecyclerView();

    void showMessage(@StringRes int resId);

    void refresh();

    void refreshRemove();

    void showMessage(String msg);
  }
}
