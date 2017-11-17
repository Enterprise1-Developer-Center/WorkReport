package kr.co.e1.workreport.main;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.DateUtils;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.main.adapter.MainAdapterDataModel;
import kr.co.e1.workreport.main.model.SummaryReportContent;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.project.vo.Project;

import static kr.co.e1.workreport.network.WResult.RESULT_SUCCESS;

/**
 * Created by jaeho on 2017. 9. 25
 */

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private MainAdapterDataModel<ReportEntry> adapterDataModel;
  private MainNetwork network;

  @Inject public MainPresenterImpl(MainPresenter.View view,
      MainAdapterDataModel<ReportEntry> adapterDataModel, MainNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
    view.changeTheme();
  }

  @DebugLog @Override public void onCreate(Bundle savedInstanceState) {
    view.showLoginFragment(savedInstanceState);
    view.setListener();
    view.setRecyclerView();
  }

  @Override public void onNavigationItemSelected(int itemId) {
    if (itemId == R.id.nav_statistics) {
      view.navigateToStatistics();
    } else if (itemId == R.id.nav_team_report) {
      view.navigateToTeamReport();
    } else if (itemId == R.id.nav_password) {
      view.showPasswordChangeDialog();
    } else if (itemId == R.id.nav_review) {
      view.navigateToReview();
    }
  }

  private static WResult<ReportContent> result;

  @Nonnull private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onLoginSuccess(String date) {
    view.showProgress();
    compositeDisposable.add(network.getWorkingDay(date)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          MainPresenterImpl.this.result = result;
          if (result.getResult() == RESULT_SUCCESS) {
            List<ReportEntry> items = ReportEntry.createReportEntrys(result.getContent());
            adapterDataModel.addAll(items);
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

  @Override public void onBackPressed(boolean isDrawerOpen) {
    if (isDrawerOpen) {
      view.closeDrawer();
    } else {
      view.finish();
    }
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
  }

  @Override public void onSaveClick(SummaryReportContent c) {
    view.showProgress();
    view.refreshRemove();
    adapterDataModel.clear();
    compositeDisposable.add(
        network.updateWorkingDay(c.getLcls_cd(), c.getMcls_cd(), c.getDetail(), c.getProj_cd(),
            c.getS_time(), c.getE_time(), c.getUpd_time(), c.getUser_id(), c.getWork_ymd())
            .subscribeOn(Schedulers.io())
            .delay(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(result -> {
              MainPresenterImpl.this.result = result;
              if (result.getResult() == WResult.RESULT_SUCCESS) {

                adapterDataModel.addAll(ReportEntry.createReportEntrys(result.getContent()));
                view.refresh();
                view.showMessage(R.string.save_completed);
              } else if (result.getResult() == WResult.RESULT_FAILURE) {
                view.showMessage(result.getMsg());
              } else {
                view.showMessage(R.string.error_server_error);
              }
              view.hideProgress();
            }, throwable -> {
              view.hideProgress();
              view.showMessage(R.string.error_server_error);
            }));
  }

  @DebugLog @Override public void onItemClick(ReportEntry item) {
    ReportType type = item.getType();
    if (type == ReportType.DATE) {
      dateHandling(item);
    } else if (type == ReportType.START_TIME) {
      startTimeHandling(item);
    } else if (type == ReportType.END_TIME) {
      endTimeHandling(item);
    } else if (type == ReportType.DETAIL_WORK) {
      view.showClassificationDialog(result.getContent().getMcls());
    } else if (type == ReportType.PROJECT) {
      view.showProjectChoiceDialog(result.getContent().getProj());
    }
  }

  private void dateHandling(ReportEntry entry) {
    String contents = entry.getContents();
    Map<String, Integer> map = DateUtils.getYearMonthDayMap(DateUtils.getOnlyDateString(contents));
    int year = map.get("year");
    int month = DateUtils.getMonthOfYear(map.get("month"));
    int day = map.get("day");
    view.showDatePickerDialog(year, month, day, ($datePicker, $year, $month, $dayOfMonth) -> {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
      Calendar calendar = Calendar.getInstance();
      calendar.set($year, $month, $dayOfMonth);
      Date d = new Date(calendar.getTimeInMillis());
      String date = dateFormat.format(d);

      adapterDataModel.edit(ReportType.DATE, date);
      view.refresh(ReportType.DATE.getPosition());
    });
  }

  private void startTimeHandling(ReportEntry entry) {
    ReportType type = entry.getType();

    Map<String, Integer> timeMap = DateUtils.convertTimeToMap(entry.getContents());
    view.showTimePickerDialog(timeMap.get("hour"), timeMap.get("minute"),
        ($timePicker, $hourOfDay, $minute) -> {
          Date d = new Date(DateUtils.convertTimeToMillis($hourOfDay, $minute));
          adapterDataModel.edit(type, DateUtils.getConvertoFormat(d, "HH:mm"));
          view.refresh(type.getPosition());
        });
  }

  private void endTimeHandling(ReportEntry entry) {
    ReportType type = entry.getType();

    Map<String, Integer> timeMap = DateUtils.convertTimeToMap(entry.getContents());
    view.showTimePickerDialog(timeMap.get("hour"), timeMap.get("minute"),
        ($timePicker, $hourOfDay, $minute) -> {
          Date d = new Date(DateUtils.convertTimeToMillis($hourOfDay, $minute));
          adapterDataModel.edit(type, DateUtils.getConvertoFormat(d, "HH:mm"));
          view.refresh(type.getPosition());
        });
  }

  @DebugLog @Override public void onDetailWorkDialogClick(DetailWork detailWork) {
    adapterDataModel.edit(ReportType.DETAIL_WORK, detailWork);
    view.refresh(ReportType.DETAIL_WORK.getPosition());
  }

  @Override public void onProjectDialogClick(Project project) {
    adapterDataModel.edit(ReportType.PROJECT, project);
    view.refresh(ReportType.PROJECT.getPosition());
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}