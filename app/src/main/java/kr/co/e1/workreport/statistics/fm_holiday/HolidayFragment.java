package kr.co.e1.workreport.statistics.fm_holiday;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.statistics.fm_holiday.adapter.HolidayAdapter;
import kr.co.e1.workreport.statistics.fm_holiday.adapter.HolidayAdapterView;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;
import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class HolidayFragment extends BaseFragment implements HolidayFragmentPresenter.View,
    OnRecyclerItemClickListener<Holiday> {

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

  }

  @Override public void showMessage(int resId) {

  }

  @Override public void refresh() {

  }

  @Override public void removeRefresh() {

  }

  @Override public void showMessage(String msg) {

  }

  @Override public void showEditHolidayDialog(Holiday item) {

  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void onItemClick(Holiday item) {

  }

  @Override public void onDetach() {
    presenter.onDetach();
    super.onDetach();
  }
}
