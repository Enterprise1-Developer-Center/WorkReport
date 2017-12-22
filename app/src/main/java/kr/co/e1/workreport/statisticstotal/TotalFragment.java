package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.chart) BarChart chart;
  @BindView(R.id.chart2) HorizontalBarChart chart2;

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

  @Override public void showChart(BarData barData, TotalSummary totItem, String[] quarters) {
    chart.animateY(Constants.CHART_ANI_DURATION);
    chart.setData(barData);
    chart.invalidate();
    chart.zoom(2f, 1f, 1f, 1f);
    chart.setDoubleTapToZoomEnabled(false);
    chart.setPinchZoom(false);
    chart.getDescription().setEnabled(false);
    //memberCurOpRatioTextView.setText(getString(R.string.now_op_ratio) + " : " + yearOpRatio);

    XAxis xAxis = chart.getXAxis();
    xAxis.setDrawGridLines(false);
    xAxis.setAxisLineColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setGranularity(1.0f);
    xAxis.setValueFormatter((value, axis) -> {
      try {
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        return quarters[0];
      }
    });
  }
  @DebugLog @Override public void showChart2(BarData barData, TotalSummary totItem, String[] quarters) {
    chart2.animateY(Constants.CHART_ANI_DURATION);
    chart2.setData(barData);
    chart2.zoom(0.3f, 0.3f, 0.3f, 0.3f);
    chart2.setDoubleTapToZoomEnabled(false);
    chart2.setPinchZoom(false);
    chart2.getDescription().setEnabled(false);

    XAxis xAxis = chart2.getXAxis();
    xAxis.setDrawGridLines(false);
    xAxis.setAxisLineColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
    xAxis.setLabelRotationAngle(55f);
    xAxis.setXOffset(37);
    xAxis.setGranularity(1);
    xAxis.setValueFormatter((value, axis) -> {
      try {
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        return quarters[0];
      }
    });

    chart2.invalidate();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }
e
  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}