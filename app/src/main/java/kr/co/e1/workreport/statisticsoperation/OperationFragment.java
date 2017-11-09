package kr.co.e1.workreport.statisticsoperation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
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
  @BindView(R.id.progress_bar) ProgressBar progressBar;

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

    LineDataSet dataSet = new LineDataSet(entries, "가동률");

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
    lineChart.animateY(1000);
    lineChart.setData(lineData);
    lineChart.invalidate();
    final String[] quarters = new String[] {
        "01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"
    };

    Description description = lineChart.getDescription();
    description.setTextSize(13);
    description.setText("연간 가동율 : 40.9");
    description.setTextColor(ContextCompat.getColor(getContext(),R.color.colorAccent));

    XAxis xAxis = lineChart.getXAxis();
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
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void showChart() {
    setLineData();
  }

}