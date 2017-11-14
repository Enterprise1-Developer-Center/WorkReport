package kr.co.e1.workreport.main;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.DateUtils;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.main.adapter.MainAdapterDataModel;
import kr.co.e1.workreport.network.NetworkHelper;

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

  @Override public void onSaveClick(List<ReportEntry> items) {
    view.showProgress();
    new Handler().postDelayed(() -> {
      view.showMessage(R.string.save_completed);
      view.hideProgress();
    }, 1000);
  }

  @Override public void onItemClick(ReportEntry item) {
    ReportType type = item.getType();

    if (type == ReportType.DATE) {
      dateHandling(item);
    } else if (type == ReportType.START_TIME) {
      startTimeHandling(item);
    } else if (type == ReportType.END_TIME) {
      endTimeHandling(item);
    } else if (type == ReportType.DETAIL_WORK) {
      String contents = item.getContents();
      if (!TextUtils.isEmpty(contents)) {
        int code = Integer.valueOf(contents.split("/")[0].trim());
        String work = contents.split("/")[1].trim();
        view.showClassificationDialog(code, work);
      }
    } else if (type == ReportType.PROJECT) {

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

  @Override public void onDetailWorkDialogClick(Bundle o) {
    adapterDataModel.edit(ReportType.DETAIL_WORK,
        o.getString("code") + " / " + o.getString("work"));
    view.refresh(ReportType.DETAIL_WORK.getPosition());
  }

  @Override public void onProjectDialogClick(Bundle o) {
    adapterDataModel.edit(ReportType.PROJECT, o.getString("name"));
    view.refresh(ReportType.PROJECT.getPosition());
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}