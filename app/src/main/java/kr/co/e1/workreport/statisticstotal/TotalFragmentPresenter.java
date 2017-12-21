package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.github.mikephil.charting.data.BarData;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;

/**
 * Created by jaeho on 2017. 11. 2
 */

public interface TotalFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onDetach();

  interface View {

    void showProgress();

    void hideProgress();

    void showMessage(@StringRes int resId);

    void showMessage(String msg);

    void showChart(BarData barData, TotalSummary totItem, String[] quarters);
  }
}
