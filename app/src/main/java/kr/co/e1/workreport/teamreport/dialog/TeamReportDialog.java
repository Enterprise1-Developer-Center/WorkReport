package kr.co.e1.workreport.teamreport.dialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreport.dialog.adapter.TeamDialogAdapterView;
import kr.co.e1.workreport.teamreport.dialog.adapter.TeamReportDialogAdapter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 11. 1
 */
public class TeamReportDialog extends BaseAlertDialogFragment
    implements TeamReportDialogPresenter.View, OnRecyclerItemClickListener<ReportEntry> {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Inject TeamReportDialogAdapter adapter;
  @Inject TeamDialogAdapterView adapterView;
  @Inject TeamReportDialogPresenter presenter;

  @Accessors(chain = true) @Getter @Setter private String userId;

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
    return true;
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

  @Override public void showDatePickerDialog(int year, int month, int day,
      DatePickerDialog.OnDateSetListener listener) {
    new DatePickerDialog(getContext(), listener, year, month, day).show();
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

  @BindView(R.id.root_view) View rootView;

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void refreshRemove() {
    adapterView.refreshRemove();
  }

  @Override public void onItemClick(ReportEntry item) {
    presenter.onItemClick(item);
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}
