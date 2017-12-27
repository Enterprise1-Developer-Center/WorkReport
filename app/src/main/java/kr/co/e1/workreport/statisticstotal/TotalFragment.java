package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.chart) HorizontalBarChart chart;
  @BindView(R.id.textview) TextView totalTextView;

  @Inject TotalFragmentPresenter presenter;

  public static TotalFragment newInstance(int year) {
    TotalFragment f = new TotalFragment();
    Bundle args = new Bundle();
    args.putInt("year", year);
    f.setArguments(args);
    return f;
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_total;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(getArguments().getInt("year"));
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

  @DebugLog @Override public void showChart(BarData barData, String[] quarters) {
    chart.animateY(Constants.CHART_ANI_DURATION);
    chart.setData(barData);
    chart.zoom(0.3f, 0.3f, 0.3f, 0.3f);
    chart.setDoubleTapToZoomEnabled(false);
    chart.setPinchZoom(false);
    chart.getDescription().setEnabled(false);

    XAxis xAxis = chart.getXAxis();
    xAxis.setDrawGridLines(false);
    xAxis.setAxisLineColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
    xAxis.setLabelRotationAngle(40f);
    xAxis.setXOffset(25);
    chart.setExtraLeftOffset(35f);
    xAxis.setGranularity(1);
    xAxis.setValueFormatter((value, axis) -> {
      try {
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        return quarters[0];
      }
    });

    chart.invalidate();
  }

  @Override public void showTotal(String total) {
    totalTextView.setText(total);
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}