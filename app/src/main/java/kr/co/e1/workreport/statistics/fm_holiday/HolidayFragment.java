package kr.co.e1.workreport.statistics.fm_holiday;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.statistics.fm_holiday.adapter.HolidayAdapter;
import kr.co.e1.workreport.statistics.fm_holiday.adapter.HolidayAdapterView;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.AddHolidayDialog;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.EditHolidayDialog;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;
import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class HolidayFragment extends BaseFragment
    implements HolidayFragmentPresenter.View, OnRecyclerItemClickListener<Holiday> {

  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @Inject @Getter HolidayAdapter adapter;
  @Inject HolidayAdapterView adapterView;
  @Inject HolidayFragmentPresenter presenter;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_holiday;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(getArguments());
  }

  @Override protected boolean isDagger() {
    return true;
  }

  public static HolidayFragment newInstance(int year) {
    HolidayFragment f = new HolidayFragment();
    Bundle args = new Bundle();
    args.putInt("year", year);
    f.setArguments(args);
    return f;
  }

  @Override public void setRecyclerView() {
    LinearLayoutManager layout = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layout);
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
    recyclerView.getItemAnimator().setRemoveDuration(Constants.ANI_DURATION);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void removeRefresh() {
    adapterView.refreshRemove();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showEditHolidayDialog(Holiday item) {
    new EditHolidayDialog().setHoliday(item)
        .setOnCompleteListener(() -> presenter.onComplete())
        .show(getFragmentManager(), EditHolidayDialog.class.getSimpleName());
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showAddHolidayDialog() {
    new AddHolidayDialog().setOnCompleteListener(() -> presenter.onComplete())
        .show(getFragmentManager(), AddHolidayDialog.class.getSimpleName());
  }

  @DebugLog @Override public void onItemClick(Holiday item) {
    presenter.onItemClick(item);
  }

  @OnClick(R.id.fab) void onFabClick() {
    presenter.onFabClick();
  }

  @Override public void onDetach() {
    presenter.onDetach();
    super.onDetach();
  }
}
