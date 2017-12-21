package kr.co.e1.workreport.statisticstotal;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 12. 12
 */

public class TotalChartDataGen {

  private List<TotalSummary> items;
  @Getter private TotalSummary totItem;

  private Context context;

  public TotalChartDataGen(Context context) {
    this.context = context;
  }

  public String[] getQuarters() {
    final List<TotalSummary> items = this.items;
    int size = items.size();
    final String[] quarters = new String[items.size()];
    for (int i = 0; i < size; i++) {
      quarters[i] = items.get(i).getName();
    }
    return quarters;
  }

  public BarData getBarData() {
    items.remove(items.size() - 1);
    List<TotalSummary> items = this.items;
    List<BarEntry> entries = new ArrayList<>();
    List<BarEntry> values = new ArrayList<>();
    for (int i = 0; i < items.size(); i++) {
      TotalSummary item = items.get(i);
      entries.add(new BarEntry(i, item.getValue()));
      values.add(new BarEntry(i, item.getValue()));
    }

    BarDataSet dataSet = new BarDataSet(entries, context.getString(R.string.members));
    dataSet.setHighLightColor(ContextCompat.getColor(context, R.color.colorPrimary));
    dataSet.setDrawValues(true);
    dataSet.setValueTextSize(12f);
    dataSet.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
    dataSet.setValues(values);

    List<IBarDataSet> dataSets = new ArrayList<>();
    dataSets.add(dataSet);
    BarData barData = new BarData(dataSets);
    barData.setValueTextColor(Color.BLACK);
    barData.setBarWidth(0.6f);

    return barData;
  }

  public void setItems(List<TotalSummary> items) {
    totItem = items.remove(items.size() - 1);
    this.items = items;
  }
}