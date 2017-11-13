package kr.co.e1.workreport.main;

import android.os.Bundle;
import android.os.Handler;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

  @DebugLog @Override public void onReportDateSet(int year, int month, int dayOfMonth) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EE)");
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, dayOfMonth);
    Date d = new Date(calendar.getTimeInMillis());
    String date = dateFormat.format(d);

    adapterDataModel.edit(ReportType.DATE, date);
    view.refresh(ReportType.DATE.getPosition());

    view.showProgress();
    new Handler().postDelayed(() -> {
      view.hideProgress();
    }, 1000);
  }

  @DebugLog @Override public void onStartTimeSet(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
    Date date = new Date(calendar.getTimeInMillis());

    String startTime = new SimpleDateFormat("HH:mm", Locale.KOREA).format(date);
    adapterDataModel.edit(ReportType.START_TIME, startTime);
    view.refresh(ReportType.START_TIME.getPosition());
  }

  @DebugLog @Override public void onEndTimeSet(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
    Date date = new Date(calendar.getTimeInMillis());

    String endTime = new SimpleDateFormat("HH:mm", Locale.KOREA).format(date);
    adapterDataModel.edit(ReportType.END_TIME, endTime);
    view.refresh(ReportType.END_TIME.getPosition());
  }

  @Override public void onSaveClick(List<ReportEntry> items) {
    view.showProgress();
    new Handler().postDelayed(() -> {
      view.showMessage(R.string.save_completed);
      view.hideProgress();
    }, 1000);
  }

  @Override public void onItemClick(ReportEntry item) {
    switch (item.getEntry()) {
      case DATE:
        Map<String, Integer> map =
            DateUtils.getYearMonthDayMap(DateUtils.getRemoveDayOfWeekDate(item.getContents()));
        view.showDatePickerDialog(map.get("year"), DateUtils.getMonthOfYear(map.get("month")),
            map.get("day"));
        break;
      case START_TIME:
        view.showStartTimePickerDialog();
        break;
      case END_TIME:
        view.showEndTimePickerDialog();
        break;
      case DETAIL_WORK:
        view.showDetailWorkDialog();
        break;
      case PROJECT:
        view.showProjectChoiceDialog();
        break;
    }
  }

  @Override public void onDetailWorkDialogClick(Bundle o) {
    adapterDataModel.edit(ReportType.DETAIL_WORK,
        o.getString("code") + " // " + o.getString("work"));
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