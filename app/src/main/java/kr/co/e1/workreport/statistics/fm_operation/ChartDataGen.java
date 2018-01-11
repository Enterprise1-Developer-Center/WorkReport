package kr.co.e1.workreport.statistics.fm_operation;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
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
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.statistics.fm_operation.model.CurrOperationRate;
import kr.co.e1.workreport.statistics.fm_operation.model.YearOperationRate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 11. 22
 */

public class ChartDataGen {

  private Context context;
  @Accessors(chain = true) @Setter private List<CurrOperationRate> currOperationRates;
  @Getter private float currTotRate;

  public ChartDataGen(Context context) {
    this.context = context;
  }

  public String[] getCurrOperationRateQuarters() {
    List<CurrOperationRate> items = currOperationRates;
    int size = items.size();
    String[] names = new String[size];
    for (int i = 0; i < size; i++) {
      CurrOperationRate item = items.get(i);
      names[i] = item.getUser_nm();
    }

    return names;
  }

  public BarData getCurrOperationRateData() {
    List<CurrOperationRate> items = currOperationRates;
    List<BarEntry> entries = new ArrayList<>();
    List<BarEntry> values = new ArrayList<>();
    for (int i = 0; i < items.size(); i++) {
      CurrOperationRate item = items.get(i);
      currTotRate = item.getTot_rate();
      entries.add(new BarEntry(i, item.getMan_rate()));
      values.add(new BarEntry(i, item.getMan_rate()));
    }

    BarDataSet dataSet = new BarDataSet(entries, context.getString(R.string.members));
    dataSet.setHighLightColor(ContextCompat.getColor(context, R.color.colorPrimary));
    dataSet.setDrawValues(true);
    dataSet.setValueTextSize(12f);
    dataSet.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
    dataSet.setValues(values);
    dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

    List<IBarDataSet> dataSets = new ArrayList<>();
    dataSets.add(dataSet);
    BarData barData = new BarData(dataSets);
    barData.setValueTextColor(Color.BLACK);
    barData.setBarWidth(0.5f);

    return barData;
  }

  @Setter private List<YearOperationRate> yearOperationRates;
  @Getter private float year_tot_rate;

  public String[] getYearOperationRateQuarters() {
    final int size = yearOperationRates.size();
    final String[] quarters = new String[size];
    for (int i = 0; i < quarters.length; i++) {
      YearOperationRate item = yearOperationRates.get(i);
      quarters[i] = item.getMon() + MyApplication.getInstance().getString(R.string.month);
    }
    return quarters;
  }

  public LineData getYearOperationRateData() {
    final int size = yearOperationRates.size();
    final float[] opRatioFloats = new float[size];
    for (int i = 0; i < size; i++) {
      YearOperationRate item = yearOperationRates.get(i);
      opRatioFloats[i] = item.getMon_rate();
      year_tot_rate = item.getTot_rate();
    }

    List<Entry> entries = new ArrayList<>();
    List<Entry> values = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      entries.add(new Entry(i, opRatioFloats[i]));
      values.add(new Entry(i, opRatioFloats[i]));
    }

    LineDataSet dataSet = new LineDataSet(entries, context.getString(R.string.monthly));
    dataSet.setLineWidth(1.0f);
    dataSet.setCircleRadius(3.5f);
    dataSet.setHighLightColor(ContextCompat.getColor(context, R.color.colorPrimary));
    dataSet.setCircleColor(ContextCompat.getColor(context, R.color.colorAccent));
    dataSet.setDrawValues(true);
    dataSet.setValueTextSize(12f);
    dataSet.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
    dataSet.setValues(values);
    dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

    List<ILineDataSet> dataSets = new ArrayList<>();
    dataSets.add(dataSet);
    LineData lineData = new LineData(dataSets);
    lineData.setValueTextColor(Color.BLACK);

    return lineData;
  }
}