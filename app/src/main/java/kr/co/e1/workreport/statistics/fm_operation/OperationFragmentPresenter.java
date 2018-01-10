package kr.co.e1.workreport.statistics.fm_operation;

import android.support.annotation.StringRes;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.LineData;

/**
 * Created by jaeho on 2017. 11. 2
 */

public interface OperationFragmentPresenter {

  void onClick(int id);

  void onDetach();

  void onActivityCreate(int year);

  interface View {

    void showProgress();

    void hideProgress();

    void detailButtonEnabled(boolean enabled);

    void navigateToOpDetail();

    void showMessage(@StringRes int resId);

    void showYearOpRatioChart(LineData lineData, float yearOpRatio, String[] quarters);

    void showNowOpRatioChart(BarData barData, float yearOpRatio, String[] quarters);

    void showMessage(String msg);
  }
}
