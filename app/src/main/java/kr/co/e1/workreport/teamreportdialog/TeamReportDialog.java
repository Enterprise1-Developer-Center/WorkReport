package kr.co.e1.workreport.teamreportdialog;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import java.util.Calendar;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 11. 1
 */
public class TeamReportDialog extends BaseAlertDialogFragment
    implements TeamReportDialogPresenter.View {
  @BindView(R.id.save_button) ImageView saveButton;

  @Override protected boolean isNegativeButton() {
    return false;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Inject TeamReportDialogPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return R.layout.fragment_report;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.empty_text;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return null;
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }

  @Override public void hideSaveButton() {
    saveButton.setVisibility(View.GONE);
  }

  @Override public void showDatePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int cYear = calendar.get(Calendar.YEAR);
    int cMonth = calendar.get(Calendar.MONTH);
    int cDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    Timber.d("year = " + cYear + ", month = " + cMonth + ", day = " + cDayOfMonth);

    new DatePickerDialog(getContext(), (datePicker, year, month, dayOfMonth) -> {
      presenter.onDateSet(year, month, dayOfMonth);
    }, cYear, cMonth, cDayOfMonth).show();
  }

  @BindView(R.id.date_textview) TextView dateTextView;

  @Override public void setDate(String date) {
    dateTextView.setText(date);
  }

  @BindView(R.id.progressbar) ProgressBar progressBar;

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @OnClick(R.id.date_container) void onClick(View view) {
    presenter.onClick(view.getId());
  }
}
