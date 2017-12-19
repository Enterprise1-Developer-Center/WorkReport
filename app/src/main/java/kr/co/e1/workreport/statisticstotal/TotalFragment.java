package kr.co.e1.workreport.statisticstotal;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.chart) HorizontalBarChart chart;

  @Inject TotalFragmentPresenter presenter;

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

  @Override public void showChart(BarData barData, String[] quarters) {

    chart.setDrawBarShadow(false);
    chart.setDrawValueAboveBar(true);
    chart.getDescription().setEnabled(false);
    chart.setPinchZoom(false);
    chart.setDrawGridBackground(false);
    chart.setFitBars(true);
    chart.animateY(Constants.ANI_DURATION);
    chart.setData(barData);

    XAxis xl = chart.getXAxis();
    xl.setPosition(XAxis.XAxisPosition.BOTTOM);
    xl.setTypeface(Typeface.DEFAULT);
    xl.setDrawAxisLine(true);
    xl.setDrawGridLines(false);
    //xl.setGranularity(10f);
    xl.setValueFormatter((value, axis) -> {
      try {
        Timber.d("quarter = " + quarters[(int) value] + ", value = " + value);
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
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