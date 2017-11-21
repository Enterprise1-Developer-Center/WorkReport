package kr.co.e1.workreport.teamreportdialog;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 1
 */

public class TeamReportDialogPresenterImpl implements TeamReportDialogPresenter {

  private TeamReportDialogPresenter.View view;
  private BaseAdapterDataModel<ReportEntry> adapterDataModel;
  private TeamReportDialogNetwork network;
  private String userId;

  TeamReportDialogPresenterImpl(TeamReportDialogPresenter.View view,
      BaseAdapterDataModel<ReportEntry> adapterDataModel, TeamReportDialogNetwork network, String userId) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
    this.userId = userId;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();
    view.showProgress();

    compositeDisposable.add(network.getWorkingDay(PreferencesUtils.getToday(), userId)
        .subscribeOn(Schedulers.io())
        .delay(500, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            adapterDataModel.addAll(ReportEntry.createReportEntrys(result.getContent()));
            view.refresh();
          } else {
            view.showMessage(R.string.error_server_error);
          }

          view.hideProgress();
        }, throwable -> {
          view.hideProgress();
          view.showMessage(R.string.error_server_error);
        }));
    /*
    new Handler().postDelayed(() -> {
      List<ReportEntry> items = new ArrayList<>();
      items.add(new ReportEntry().setType(ReportType.DATE).setContents("2017-11-10(금)"));
      items.add(new ReportEntry().setType(ReportType.DEPT).setContents("BS"));
      items.add(new ReportEntry().setType(ReportType.NAME).setContents("오재호"));
      items.add(new ReportEntry().setType(ReportType.START_TIME).setContents("2017-09-18 18:00"));
      items.add(new ReportEntry().setType(ReportType.END_TIME).setContents("2017-09-18 22:00"));
      items.add(new ReportEntry().setType(ReportType.WORKING_TIME).setContents("04:00"));
      items.add(new ReportEntry().setType(ReportType.DETAIL_WORK).setContents("11, 구조파악.."));
      items.add(new ReportEntry().setType(ReportType.PROJECT).setContents("설계개발공유체게"));
      items.add(
          new ReportEntry().setType(ReportType.MODIFIED_TIME).setContents("2017-11-10 22:05"));
      adapterDataModel.addAll(items);

      //view.refresh();
      for (int i = 0; i < items.size(); i++) {
        view.refresh(i);
      }

      view.hideProgress();
    }, 1000);
    */
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
