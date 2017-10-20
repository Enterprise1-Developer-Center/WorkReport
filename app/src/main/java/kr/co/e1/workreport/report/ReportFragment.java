package kr.co.e1.workreport.report;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import java.util.Calendar;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class ReportFragment extends BaseFragment implements ReportFragmentPresenter.View {

  @Inject ReportFragmentPresenter presenter;

  @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
  @BindView(R.id.save_button) ImageView saveButton;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_report;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  public static ReportFragment newInstance(Bundle args) {
    ReportFragment f = new ReportFragment();
    f.setArguments(args);
    return f;
  }

  @OnClick({
      R.id.date_container, R.id.start_time_container, R.id.end_time_container, R.id.code_container,
      R.id.project_container, R.id.save_button
  }) public void onClick(View view) {
    presenter.onClick(view.getId());
  }

  @Override public void showReportDatePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    Timber.d("year = " + year + ", month = " + month + ", day = " + day);

    Context context =
        new ContextThemeWrapper(getContext(), android.R.style.Theme_Holo_Light_Dialog);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      context = getContext(); // API 24 이상일 경우 시스템 기본 테마 사용
    }
    DatePickerDialog datePickerDialog =
        new DatePickerDialog(context, (datePicker, y, m, dayOfMonth) -> {
          presenter.onReportDateSet(y, m, dayOfMonth);
        }, year, month, day);
    datePickerDialog.show();
  }

  @BindView(R.id.date_textview) TextView dateTextView;

  @Override public void showDate(String date) {
    dateTextView.setText(date);
  }

  @Override public void setListener() {
    swipeRefresh.setOnRefreshListener(() -> {

    });
  }

  @Override public void showProgress() {
    swipeRefresh.setRefreshing(true);
  }

  @Override public void hideProgress() {
    swipeRefresh.setRefreshing(false);
  }

  @Override public void enableSaveButton() {
    saveButton.setEnabled(true);
    saveButton.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary));
  }

  @Override public void disableSaveButton() {
    saveButton.setEnabled(false);
    saveButton.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorLight));
  }
}
