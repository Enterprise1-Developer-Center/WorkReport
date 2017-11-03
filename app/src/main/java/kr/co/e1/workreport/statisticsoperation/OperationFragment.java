package kr.co.e1.workreport.statisticsoperation;

import android.os.Bundle;
import butterknife.BindView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */
public class OperationFragment extends BaseFragment implements OperationFragmentPresenter.View {

  @BindView(R.id.line_chart) LineChart lineChart;
  @BindView(R.id.bar_chart) BarChart barChart;
  @Inject OperationFragmentPresenter presenter;

  public static OperationFragment newInstance() {
    return new OperationFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_operation_ratio;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);

    setLineData();
    setBarData();
    setBarLineData();
  }

  private void setBarLineData() {

  }

  private void setBarData() {
    List<BarEntry> entries = new ArrayList<>();
    entries.add(new BarEntry(0f, 30f));
    entries.add(new BarEntry(1f, 80f));
    entries.add(new BarEntry(2f, 60f));
    entries.add(new BarEntry(3f, 50f));
    // gap of 2f
    entries.add(new BarEntry(5f, 70f));
    entries.add(new BarEntry(6f, 60f));

    BarDataSet set = new BarDataSet(entries, "BarDataSet");

    BarData data = new BarData(set);
    data.setBarWidth(0.9f); // set custom bar width
    barChart.setData(data);
    barChart.animateXY(2000, 2000);
    barChart.setFitBars(true); // make the x-axis fit exactly all bars
    barChart.invalidate(); // refresh

    final String[] quarters = new String[] { "01월", "02월", "03월", "04월", "05월", "06월", "07월" };

    XAxis xAxis = barChart.getXAxis();
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setGranularity(1f);
    xAxis.setValueFormatter((value, axis) -> {
      Timber.d("value = " + value);
      try {
        return quarters[(int) value];
      } catch (ArrayIndexOutOfBoundsException e) {
        return quarters[0];
      }
    });
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

    LineDataSet dataSet = new LineDataSet(entries, "BS OP Ratio");
    dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

    List<ILineDataSet> dataSets = new ArrayList<>();
    dataSets.add(dataSet);
    LineData lineData = new LineData(dataSets);
    lineChart.animateXY(2000, 2000);
    lineChart.setData(lineData);
    lineChart.invalidate();

    final String[] quarters = new String[] {
        "01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"
    };

    XAxis xAxis = lineChart.getXAxis();
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setGranularity(1f);
    xAxis.setValueFormatter((value, axis) -> {
      Timber.d("value = " + value);
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
}