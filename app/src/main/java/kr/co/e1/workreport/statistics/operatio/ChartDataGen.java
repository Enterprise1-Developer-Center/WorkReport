package kr.co.e1.workreport.statistics.operatio;

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
import kr.co.e1.workreport.statistics.operatio.model.OpRatioContent;
import kr.co.e1.workreport.statistics.operatio.model.OpRatioHeader;
import kr.co.e1.workreport.statistics.operatio.model.OpRatioItem;
import kr.co.e1.workreport.statistics.operatio.model.OpRatioTotal;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 11. 22
 */

public class ChartDataGen {

  private Context context;
  @Accessors(chain = true) @Setter private OpRatioContent opRatioContent;

  public ChartDataGen(Context context) {
    this.context = context;
  }

  public String[] getYearOpRatioQuarters() {
    OpRatioHeader h = opRatioContent.getHeader();

    return new String[] {
        h.getJan(), h.getFeb(), h.getMar(), h.getApr(), h.getMay(), h.getJun(), h.getJul(),
        h.getAug(), h.getSep(), h.getOct(), h.getNov(), h.getDec()
    };
  }

  public float getYearOpRatio() {
    return opRatioContent.getOpRatioTotal().getYearOpr();
  }

  public LineData getYearOpRatioChartData() {
    OpRatioTotal t = opRatioContent.getOpRatioTotal();
    final float[] opRatioFloats = new float[] {
        t.getJan(), t.getFeb(), t.getMar(), t.getApr(), t.getMay(), t.getJun(), t.getJul(),
        t.getAug(), t.getSep(), t.getOct(), t.getNov(), t.getDec()
    };
    List<Entry> entries = new ArrayList<>();
    List<Entry> values = new ArrayList<>();
    for (int i = 0; i < opRatioFloats.length; i++) {
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

  public float getNowOpRatio() {
    return opRatioContent.getOpRatioTotal().getCurOpr();
  }

  public String[] getNowOpRatioQuarters() {
    List<OpRatioItem> items = opRatioContent.getOpRatios();
    int size = items.size();
    String[] names = new String[size];
    for (int i = 0; i < size; i++) {
      OpRatioItem item = items.get(i);
      names[i] = item.getUserNm();
    }

    return names;
  }

  public BarData getNowOpRatioChartData() {
    List<OpRatioItem> items = opRatioContent.getOpRatios();
    List<BarEntry> entries = new ArrayList<>();
    List<BarEntry> values = new ArrayList<>();
    for (int i = 0; i < items.size(); i++) {
      OpRatioItem item = items.get(i);
      item.getCurOpr();
      entries.add(new BarEntry(i, item.getCurOpr()));
      values.add(new BarEntry(i, item.getCurOpr()));
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
}