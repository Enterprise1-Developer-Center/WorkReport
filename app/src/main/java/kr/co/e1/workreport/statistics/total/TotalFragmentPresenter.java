package kr.co.e1.workreport.statistics.total;

import android.support.annotation.StringRes;
import com.github.mikephil.charting.data.BarData;

/**
 * Created by jaeho on 2017. 11. 2
 */

public interface TotalFragmentPresenter {

  void onActivityCreate(int year);

  void onDetach();

  interface View {

    void showProgress();

    void hideProgress();

    void showMessage(@StringRes int resId);

    void showMessage(String msg);

    void showChart(BarData barData, String[] quarters);

    void showTotal(String total);
  }
}
