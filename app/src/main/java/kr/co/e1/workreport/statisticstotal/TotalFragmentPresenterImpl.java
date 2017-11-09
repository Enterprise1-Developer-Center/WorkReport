package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.os.Handler;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class TotalFragmentPresenterImpl implements TotalFragmentPresenter {

  private View view;

  TotalFragmentPresenterImpl(View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.showProgress();
    new Handler().postDelayed(() -> {
      view.showProfits("1197");
      view.showInvest("340");
      view.showLoss("0");
      view.showSupport("8");
      view.showEducate("138");
      view.showVacation("71");
      view.showSum("1414");
      view.hideProgress();
    }, 1000);
  }
}
