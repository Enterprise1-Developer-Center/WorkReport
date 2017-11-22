package kr.co.e1.workreport.statisticsop;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.LineData;

/**
 * Created by jaeho on 2017. 11. 2
 */

public interface OperationFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onClick(int id);

  void onDetach();

  interface View {

    void showProgress();

    void hideProgress();

    void detailButtonEnabled(boolean enabled);

    void navigateToOpDetail();

    void showMessage(@StringRes int resId);

    void showDeptChart(LineData lineData, float yearOpRatio, String[] quarters);

    void showMemberChart(BarData barData, float yearOpRatio, String[] quarters);

    void showMessage(String msg);
  }
}
