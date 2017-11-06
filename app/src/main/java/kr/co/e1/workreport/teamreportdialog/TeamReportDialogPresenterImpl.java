package kr.co.e1.workreport.teamreportdialog;

import android.os.Bundle;
import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 11. 1
 */

public class TeamReportDialogPresenterImpl implements TeamReportDialogPresenter {

  private TeamReportDialogPresenter.View view;

  TeamReportDialogPresenterImpl(TeamReportDialogPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.hideSaveButton();
    test();
  }

  @Override public void onClick(int id) {
    switch (id) {
      case R.id.date_container:
        view.showDatePickerDialog();
        break;
    }
  }
  private void test() {
    view.showProgress();
    new Handler().postDelayed(() -> {
      view.hideProgress();
      view.showGroup("BS");
      view.showPerson("jaeho");
      view.showStartTime("19:00");
      view.showEndTime("22:00");
      view.showCode("11 | show me the money");
      view.showProject("show me the mory");
      view.showLastEditDateTime("2017-10-23(수) 14:12");
      view.showWorkTime("03:00");
    }, 2000);

  }
  @Override public void onDateSet(int year, int month, int dayOfMonth) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    Date d = new Date(calendar.getTimeInMillis());
    String reportDate = dateFormat.format(d);
    view.showDate(reportDate);
    test();
  }
}
