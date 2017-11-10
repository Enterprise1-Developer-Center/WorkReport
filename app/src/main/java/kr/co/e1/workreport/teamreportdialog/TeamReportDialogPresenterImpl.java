package kr.co.e1.workreport.teamreportdialog;

import android.os.Bundle;
import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Report;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;

/**
 * Created by jaeho on 2017. 11. 1
 */

public class TeamReportDialogPresenterImpl implements TeamReportDialogPresenter {

  private TeamReportDialogPresenter.View view;
  private BaseAdapterDataModel<ReportEntry> adapterDataModel;

  TeamReportDialogPresenterImpl(TeamReportDialogPresenter.View view,
      BaseAdapterDataModel<ReportEntry> adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();

    view.showProgress();
    new Handler().postDelayed(() -> {
      List<ReportEntry> items = new ArrayList<>();
      items.add(new ReportEntry(Report.DATE, "2017-11-10(금)"));
      items.add(new ReportEntry(Report.GROUP, "BS"));
      items.add(new ReportEntry(Report.NAME, "오재호"));
      items.add(new ReportEntry(Report.START_TIME, "2017-09-18 18:00"));
      items.add(new ReportEntry(Report.END_TIME, "2017-09-18 22:00"));
      items.add(new ReportEntry(Report.WORKING_TIME, "04:00"));
      items.add(new ReportEntry(Report.DETAIL_WORK, "11, 구조파악.."));
      items.add(new ReportEntry(Report.PROJECT, "설계개발공유체게"));
      items.add(new ReportEntry(Report.MODIFIED_TIME, "2017-11-10 22:05"));
      adapterDataModel.addAll(items);

      //view.refresh();
      for (int i = 0; i < items.size(); i++) {
        view.refresh(i);
      }

      view.hideProgress();
    }, 2000);
  }

  @Override public void onClick(int id) {
    switch (id) {
      case R.id.date_container:
        view.showDatePickerDialog();
        break;
    }
  }

  @Override public void onDateSet(int year, int month, int dayOfMonth) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    Date d = new Date(calendar.getTimeInMillis());
    String reportDate = dateFormat.format(d);
  }
}
