package kr.co.e1.workreport.statisticsop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.statisticsopdetail.OpDetailActivity;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */
public class OperationFragment extends BaseFragment implements OperationFragmentPresenter.View {

  @BindView(R.id.year_line_chart) LineChart teamChart;
  @BindView(R.id.member_chart) BarChart memberChart;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.detail_button) Button detailButton;
  @BindView(R.id.root_view) View rootView;
  @Inject OperationFragmentPresenter presenter;

  public static OperationFragment newInstance() {
    return new OperationFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_operation_ratio;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);
    presenter.onActivityCreate(savedInstanceState);
  }

  private void setLineData() {
    List<Entry> entries = new ArrayList<>();

    entries.add(new Entry(0f, 30f));
    entries.add(new Entry(1f, 40f));
    entries.add(new Entry(2f, 80f));
    entries.add(new Entry(3f, 60f));
    entries.add(new Entry(4f, 10f));
    entries.add(new Entry(5f, 15f));
    entries.add(new Entry(6f, 30f));
    entries.add(new Entry(7f, 40f));
    entries.add(new Entry(8f, 60f));
    entries.add(new Entry(9f, 90f));
    entries.add(new Entry(10f, 100f));
    entries.add(new Entry(11f, 30.4f));

    LineDataSet dataSet = new LineDataSet(entries, "월별");

    dataSet.setLineWidth(2.0f);
    dataSet.setCircleRadius(3.5f);
    dataSet.setHighLightColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    dataSet.setCircleColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    dataSet.setDrawValues(true);
    dataSet.setValueTextSize(12f);
    dataSet.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    List<Entry> values = new ArrayList<>();
    values.add(new Entry(0f, 30f));
    values.add(new Entry(1f, 40f));
    values.add(new Entry(2f, 80f));
    values.add(new Entry(3f, 60f));
    values.add(new Entry(4f, 10f));
    values.add(new Entry(5f, 15f));
    values.add(new Entry(6f, 30f));
    values.add(new Entry(7f, 40f));
    values.add(new Entry(8f, 60f));
    values.add(new Entry(9f, 90f));
    values.add(new Entry(10f, 100f));
    values.add(new Entry(11f, 30.4f));

    dataSet.setValues(values);

    dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

    List<ILineDataSet> dataSets = new ArrayList<>();
    dataSets.add(dataSet);
    LineData lineData = new LineData(dataSets);
    lineData.setValueTextColor(Color.BLACK);
    //lineChart.animateXY(2000, 2000);
    teamChart.animateY(500);
    teamChart.setData(lineData);
    teamChart.invalidate();
    final String[] quarters = new String[] {
        "01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"
    };

    Description description = teamChart.getDescription();
    description.setTextSize(13);
    description.setText("연간 가동율 : 40.9");
    description.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

    XAxis xAxis = teamChart.getXAxis();
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

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showChart() {
    setLineData();
    setMemberData();
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

  @Override public void showDeptChart(LineData lineData) {
    teamChart.animateY(500);
    teamChart.setData(lineData);
    teamChart.invalidate();
    final String[] quarters = new String[] {
        "01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"
    };

    Description description = teamChart.getDescription();
    description.setTextSize(13);
    description.setText("연간 가동율 : 40.9");
    description.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

    XAxis xAxis = teamChart.getXAxis();
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

  @Override public void showMemberChart(BarData barData) {
    memberChart.animateY(500);
    memberChart.setData(barData);
    memberChart.invalidate();
    final String[] quarters = new String[] {
        "홍승연", "문재선", "구서현", "신명재", "최정훈", "손성필", "민병일", "이완섭", "박동선", "이미자", "장현희", "오재호", "경주원"
    };

    Description description = memberChart.getDescription();
    description.setTextSize(11.0f);
    description.setText("팀원 평균 가동률 : 40.9");
    description.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

    XAxis xAxis = memberChart.getXAxis();
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

  private void setMemberData() {
    List<BarEntry> entries = new ArrayList<>();

    entries.add(new BarEntry(0f, 30f));
    entries.add(new BarEntry(1f, 40f));
    entries.add(new BarEntry(2f, 80f));
    entries.add(new BarEntry(3f, 60f));
    entries.add(new BarEntry(4f, 10f));
    entries.add(new BarEntry(5f, 15f));
    entries.add(new BarEntry(6f, 30f));
    entries.add(new BarEntry(7f, 40f));
    entries.add(new BarEntry(8f, 60f));
    entries.add(new BarEntry(9f, 90f));
    entries.add(new BarEntry(10f, 100f));
    entries.add(new BarEntry(11f, 30.4f));
    entries.add(new BarEntry(11f, 30.4f));

    BarDataSet dataSet = new BarDataSet(entries, "팀원별");

    dataSet.setHighLightColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    dataSet.setDrawValues(true);
    dataSet.setValueTextSize(12f);
    dataSet.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    List<BarEntry> values = new ArrayList<>();
    values.add(new BarEntry(0f, 30f));
    values.add(new BarEntry(1f, 40f));
    values.add(new BarEntry(2f, 80f));
    values.add(new BarEntry(3f, 60f));
    values.add(new BarEntry(4f, 10f));
    values.add(new BarEntry(5f, 15f));
    values.add(new BarEntry(6f, 30f));
    values.add(new BarEntry(7f, 40f));
    values.add(new BarEntry(8f, 60f));
    values.add(new BarEntry(9f, 90f));
    values.add(new BarEntry(10f, 100f));
    values.add(new BarEntry(11f, 30.4f));
    values.add(new BarEntry(11f, 30.4f));

    dataSet.setValues(values);

    dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

    List<IBarDataSet> dataSets = new ArrayList<>();
    dataSets.add(dataSet);
    BarData barData = new BarData(dataSets);
    barData.setValueTextColor(Color.BLACK);
    //lineChart.animateXY(2000, 2000);
    memberChart.animateY(500);
    memberChart.setData(barData);
    memberChart.invalidate();
    final String[] quarters = new String[] {
        "홍승연", "문재선", "구서현", "신명재", "최정훈", "손성필", "민병일", "이완섭", "박동선", "이미자", "장현희", "오재호", "경주원"
    };

    Description description = memberChart.getDescription();
    description.setTextSize(11.0f);
    description.setText("팀원 평균 가동률 : 40.9");
    description.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

    XAxis xAxis = memberChart.getXAxis();
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

  @OnClick(R.id.detail_button) void onClick(View view) {
    presenter.onClick(view.getId());
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }
}