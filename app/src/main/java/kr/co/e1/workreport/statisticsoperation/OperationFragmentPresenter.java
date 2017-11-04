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

    void setChart();

    void setProfits(String value);

    void setInvest(String value);

    void setLoss(String value);

    void setSupport(String value);

    void setEducate(String value);

    void setVacation(String value);

    void setSum(String value);
  }
}
