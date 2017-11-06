package kr.co.e1.workreport.statisticsoperation;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 11. 2
 */

public interface OperationFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  interface View {

    void showProgress();

    void hideProgress();

    void showChart();

    void showProfits(String value);

    void showInvest(String value);

    void showLoss(String value);

    void showSupport(String value);

    void showEducate(String value);

    void showVacation(String value);

    void showSum(String value);
  }
}
