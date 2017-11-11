package kr.co.e1.workreport.teamreportdialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import hugo.weaving.DebugLog;
import java.util.Calendar;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.common.adapter.ReportAdapterView;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreportdialog.adapter.TeamReportAdapter;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 11. 1
 */
public class TeamReportDialog extends BaseAlertDialogFragment
    implements TeamReportDialogPresenter.View, OnRecyclerItemClickListener<ReportEntry> {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Inject TeamReportAdapter adapter;
  @Inject ReportAdapterView adapterView;
  @Inject TeamReportDialogPresenter presenter;

  @Override protected boolean isNegativeButton() {
    return false;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return R.layout.fragment_report;
  }

  @Override protected ViewGroup getInflateRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.empty_text;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      dismiss();
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return null;
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

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
  }

  @Override public void refresh(int position) {
    adapterView.refresh(position);
  }

  @DebugLog @Override public void onItemClick(ReportEntry item) {

  }
}
