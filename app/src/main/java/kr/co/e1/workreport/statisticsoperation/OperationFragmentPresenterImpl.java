package kr.co.e1.workreport.statisticsoperation;

import android.os.Bundle;
import android.os.Handler;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class OperationFragmentPresenterImpl implements OperationFragmentPresenter {

  private OperationFragmentPresenter.View view;
  OperationFragmentPresenterImpl(OperationFragmentPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.showProgress();
    new Handler().postDelayed(() -> {
      view.setChart();
      view.setProfits("1197");
      view.setInvest("340");
      view.setLoss("0");
      view.setSupport("8");
      view.setEducate("138");
      view.setVacation("71");
      view.setSum("1414");

      view.hideProgress();
    }, 1000);

  }
}
