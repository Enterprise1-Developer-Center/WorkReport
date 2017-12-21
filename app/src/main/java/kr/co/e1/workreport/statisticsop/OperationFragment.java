package kr.co.e1.workreport.statisticsop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.LineData;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.statisticsopdetail.OpDetailActivity;

/**
 * Created by jaeho on 2017. 10. 31
 */
public class OperationFragment extends BaseFragment implements OperationFragmentPresenter.View {

  @BindView(R.id.year_line_chart) LineChart yearOpRatioChart;
  @BindView(R.id.member_chart) BarChart nowOpRatioChart;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.detail_button) Button detailButton;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.year_op_ratio_textview) TextView yearOpRatioTextView;
  @BindView(R.id.member_cur_op_ratio_textview) TextView memberCurOpRatioTextView;
  @Inject OperationFragmentPresenter presenter;

  public static OperationFragment newInstance() {
    return new OperationFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_operation_ratio;
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
    progressBar.setVisibility(View.GONE);
  }

  @Override public void detailButtonEnabled(boolean enabled) {
    detailButton.setEnabled(enabled);
  }

  @Override public void navigateToOpDetail() {
    Intent intent = new Intent(getContext(), OpDetailActivity.class);
    startActivity(intent);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override
  public void showYearOpRatioChart(LineData lineData, float yearOpRatio, String[] quarters) {
    yearOpRatioChart.animateY(Constants.CHART_ANI_DURATION);
    yearOpRatioChart.setData(lineData);
    yearOpRatioChart.invalidate();
    yearOpRatioChart.zoom(2f, 1f, 1f, 1f);
    yearOpRatioChart.setDoubleTapToZoomEnabled(false);
    yearOpRatioChart.setPinchZoom(false);

    yearOpRatioTextView.setText(getString(R.string.year_op_ratio) + " : " + yearOpRatio);
    yearOpRatioChart.getDescription().setEnabled(false);

    XAxis xAxis = yearOpRatioChart.getXAxis();
    xAxis.setDrawGridLines(false);
    xAxis.setAxisLineColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setGranularity(1f);
    xAxis.setValueFormatter((value, axis) -> {
      try {
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        return quarters[0];
      }
    });
  }

  @Override public void showNowOpRatioChart(BarData barData, float yearOpRatio, String[] quarters) {
    nowOpRatioChart.animateY(Constants.CHART_ANI_DURATION);
    nowOpRatioChart.setData(barData);
    nowOpRatioChart.invalidate();
    nowOpRatioChart.zoom(2f, 1f, 2f, 2f);
    nowOpRatioChart.setDoubleTapToZoomEnabled(false);
    nowOpRatioChart.setPinchZoom(false);
    nowOpRatioChart.getDescription().setEnabled(false);
    memberCurOpRatioTextView.setText(getString(R.string.now_op_ratio) + " : " + yearOpRatio);

    XAxis xAxis = nowOpRatioChart.getXAxis();
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

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @OnClick(R.id.detail_button) void onClick(View view) {
    presenter.onClick(view.getId());
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}