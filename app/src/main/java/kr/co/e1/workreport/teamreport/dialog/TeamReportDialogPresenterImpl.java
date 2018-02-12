package kr.co.e1.workreport.teamreport.dialog;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.teamreport.dialog.adapter.TeamDialogAdapterDataModel;
import kr.co.e1.workreport.teamreport.dialog.network.TeamReportDialogNetwork;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 11. 1
 */

public class TeamReportDialogPresenterImpl implements TeamReportDialogPresenter {

  private TeamReportDialogPresenter.View view;
  private TeamDialogAdapterDataModel<ReportEntry> adapterDataModel;
  private TeamReportDialogNetwork network;
  private String userId;

  public TeamReportDialogPresenterImpl(TeamReportDialogPresenter.View view,
      TeamDialogAdapterDataModel adapterDataModel, TeamReportDialogNetwork network, String userId) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
    this.userId = userId;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();
    view.showProgress();
    req();
  }
  private void req() {
    compositeDisposable.add(network.getWorkingDay(PreferencesUtils.getToday(), userId)
        .subscribeOn(Schedulers.io())
        .delay(NetworkHelper.DELAY, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            adapterDataModel.addAll(ReportEntry.createReportEntrys(result.getContent()));
            view.refresh();
          } else {
            view.showMessage(result.getMsg());
          }

          view.hideProgress();
        }, throwable -> {
          view.hideProgress();
          view.showMessage(R.string.error_server_error);
        }));

  }
  @Override public void onItemClick(ReportEntry item) {
    String date = item.getContents().trim();
    Map<String, Integer> dateMap = DateUtils.getYmdMap(date);

    int year = dateMap.get("year");
    int month = DateUtils.getMonthOfYear(dateMap.get("month"));
    int dayOfMonth = dateMap.get("day");

    view.showDatePickerDialog(year, month, dayOfMonth,
        ($datePicker, $year, $month, $dayOfMonth) -> {
          Timber.d("year = " + $year + ", month = " + $month + ", dayOfMonth = " + $dayOfMonth);
          view.refreshRemove();
          adapterDataModel.clear();
          String dateString = DateUtils.getDateString($year, $month, $dayOfMonth, "yyyy-MM-dd");
          view.showProgress();
          compositeDisposable.add(network.getWorkingDay(dateString, userId)
              .subscribeOn(Schedulers.io())
              .delay(NetworkHelper.DELAY, TimeUnit.MILLISECONDS)
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(result -> {
                if (result.getResult() == WResult.RESULT_SUCCESS) {
                  adapterDataModel.addAll(ReportEntry.createReportEntrys(result.getContent()));
                  view.refresh();
                } else {
                  view.showMessage(result.getMsg());
                  adapterDataModel.clear();
                  req();
                }
                view.hideProgress();
              }, throwable -> {
                view.showMessage(R.string.error_server_error);
                view.hideProgress();
              }));
        });
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}
