package kr.co.e1.workreport.main;

import android.os.Bundle;
import android.os.Handler;
import hugo.weaving.DebugLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.main.adapter.MainAdapterDataModel;

/**
 * Created by jaeho on 2017. 9. 25
 */

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private MainAdapterDataModel<ReportEntry> adapterDataModel;

  @Inject public MainPresenterImpl(MainPresenter.View view,
      MainAdapterDataModel<ReportEntry> adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
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

  @DebugLog @Override public void loginComplete() {
    view.showProgress();
    new Handler().postDelayed(() -> {
      List<ReportEntry> items = new ArrayList<>();
      items.add(new ReportEntry(ReportType.DATE, "2017-11-10(금)"));
      items.add(new ReportEntry(ReportType.GROUP, "BS"));
      items.add(new ReportEntry(ReportType.NAME, "오재호"));
      items.add(new ReportEntry(ReportType.START_TIME, "17:00"));
      items.add(new ReportEntry(ReportType.END_TIME, "01:00"));
      items.add(new ReportEntry(ReportType.WORKING_TIME, "06:00"));
      items.add(new ReportEntry(ReportType.DETAIL_WORK, "11, 구조파악..?"));
      items.add(new ReportEntry(ReportType.PROJECT, "설계개발공유체계"));
      items.add(new ReportEntry(ReportType.MODIFIED_TIME, "2017-11-10 22:05"));
      adapterDataModel.addAll(items);

      //view.refresh();
      for (int i = 0; i < items.size(); i++) {
        view.refresh(i);
      }
      view.hideProgress();
    }, 1000);
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
        view.showDatePickerDialog();
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
}