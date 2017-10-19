package kr.co.e1.workreport.report;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 19
 */

public class ReportFragmentPresenterImpl implements ReportFragmentPresenter {

  private ReportFragmentPresenter.View view;

  @Inject ReportFragmentPresenterImpl(ReportFragmentPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override public void onClick(int id) {
    switch (id) {
      case R.id.date_container:
        view.showReportDatePickerDialog();
        break;
      case R.id.start_time_container:
        break;
      case R.id.end_time_container:
        break;
      case R.id.code_container:
        break;
      case R.id.project_container:
        break;
    }
  }

  @DebugLog @Override public void onReportDateSet(int year, int month, int dayOfMonth) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    Date d = new Date(calendar.getTimeInMillis());
    Timber.d(dateFormat.format(d));
    SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", Locale.KOREA);

    view.showDate(dateFormat.format(d) + " (" + dayOfWeekFormat.format(d).substring(0,1) + ")");
  }
}
