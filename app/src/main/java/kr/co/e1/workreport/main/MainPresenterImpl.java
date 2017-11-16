package kr.co.e1.workreport.main;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.adapter.ClassificationSelectableItem;
import kr.co.e1.workreport.common.DateUtils;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.main.adapter.MainAdapterDataModel;
import kr.co.e1.workreport.main.model.SummaryReportContent;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.project.adapter.ProjectSelectableItem;
import timber.log.Timber;

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

  @Nonnull private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onLoginSuccess(String date) {
    view.showProgress();
    compositeDisposable.add(network.getWorkingDay(date)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == NetworkHelper.RESULT_SUCCESS) {
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

  @Override public void onSaveClick(SummaryReportContent content) {
    view.showProgress();
    Timber.d("SummaryContent = " + content);
    compositeDisposable.add(
        network.updateWorkingDay(content.getMajorCode(), content.getSmallCode(), content.getWork(),
            content.getProjectCode(), content.getStartTime(), content.getEndTime(),
            content.getUpdateTime(), content.getUserId(), content.getDate())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<WResult<ReportContent>>() {
              @DebugLog @Override public void accept(WResult<ReportContent> reportContentWResult)
                  throws Exception {

                view.hideProgress();
              }
            }, new Consumer<Throwable>() {
              @DebugLog @Override public void accept(Throwable throwable) throws Exception {
                view.hideProgress();
              }
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
      view.showClassificationDialog(item.getSmallCode(), item.getContents());
    } else if (type == ReportType.PROJECT) {
      view.showProjectChoiceDialog(item.getProjectCode());
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
    String contents = entry.getContents();
    ReportType type = entry.getType();

    Map<String, Integer> map = DateUtils.getYearMonthDayMap(DateUtils.getOnlyDateString(contents));
    int year = map.get("year");
    int month = DateUtils.getMonthOfYear(map.get("month"));
    int day = map.get("day");

    view.showDatePickerDialog(year, month, day, ($datePicker, $year, $month, $day) -> {
      Map<String, Integer> timeMap = DateUtils.getOnlyTimeMap(entry.getContents());
      view.showTimePickerDialog(timeMap.get("hour"), timeMap.get("minute"),
          ($timePicker, $hourOfDay, $minute) -> {
            Date d = new Date(DateUtils.getTimeInMillis($year, $month, $day, $hourOfDay, $minute));
            adapterDataModel.edit(type, DateUtils.getConvertoFormat(d, "yyyy-MM-dd HH:mm"));
            view.refresh(type.getPosition());
          });
    });
  }

  private void endTimeHandling(ReportEntry entry) {
    String contents = entry.getContents();
    ReportType type = entry.getType();

    Map<String, Integer> map = DateUtils.getYearMonthDayMap(DateUtils.getOnlyDateString(contents));
    int year = map.get("year");
    int month = DateUtils.getMonthOfYear(map.get("month"));
    int day = map.get("day");
    view.showDatePickerDialog(year, month, day, ($datePicker, $year, $month, $day) -> {
      Map<String, Integer> timeMap = DateUtils.getOnlyTimeMap(entry.getContents());
      view.showTimePickerDialog(timeMap.get("hour"), timeMap.get("minute"),
          ($timePicker, $hourOfDay, $minute) -> {
            Date d = new Date(DateUtils.getTimeInMillis($year, $month, $day, $hourOfDay, $minute));
            adapterDataModel.edit(type, DateUtils.getConvertoFormat(d, "yyyy-MM-dd HH:mm"));
            view.refresh(type.getPosition());
          });
    });
  }

  @DebugLog @Override public void onDetailWorkDialogClick(ClassificationSelectableItem item) {
    adapterDataModel.edit(ReportType.DETAIL_WORK, item);
    view.refresh(ReportType.DETAIL_WORK.getPosition());
  }

  @Override public void onProjectDialogClick(ProjectSelectableItem item) {
    adapterDataModel.edit(ReportType.PROJECT, item);
    view.refresh(ReportType.PROJECT.getPosition());
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}