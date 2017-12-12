package kr.co.e1.workreport.statisticstotal;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.statisticstotal.adapter.TotalAdapter;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @BindView(R.id.chart) HorizontalBarChart chart;

  @Inject TotalAdapter adapter;
  @Inject TotalFragmentPresenter presenter;
  @Inject BaseAdapterView adapterView;

  public static TotalFragment newInstance() {
    return new TotalFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_total;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void showChart(BarData barData, String[] quarters) {
    recyclerView.setVisibility(View.INVISIBLE);

    chart.setDrawBarShadow(false);
    chart.setDrawValueAboveBar(true);
    chart.getDescription().setEnabled(false);
    chart.setMaxVisibleValueCount(60);
    chart.setPinchZoom(false);
    chart.setDrawGridBackground(false);
    chart.setData(barData);

    XAxis xl = chart.getXAxis();
    xl.setPosition(XAxis.XAxisPosition.BOTTOM);
    xl.setTypeface(Typeface.DEFAULT);
    xl.setDrawAxisLine(true);
    xl.setDrawGridLines(false);
    xl.setGranularity(10f);
    xl.setValueFormatter((value, axis) -> {
      try {
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        return quarters[0];
      }
    });

    YAxis yl = chart.getAxisLeft();
    yl.setTypeface(Typeface.DEFAULT);
    yl.setDrawAxisLine(true);
    yl.setDrawGridLines(true);
    yl.setAxisMinimum(0f);

    YAxis yr = chart.getAxisRight();
    yr.setTypeface(Typeface.DEFAULT);
    yr.setDrawAxisLine(true);
    yr.setDrawGridLines(false);
    yr.setAxisMinimum(0f);

    chart.setFitBars(true);
    chart.animateY(Constants.ANI_DURATION);

    Legend l = chart.getLegend();
    l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
    l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
    l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
    l.setDrawInside(false);
    l.setFormSize(8f);
    l.setXEntrySpace(4f);
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}