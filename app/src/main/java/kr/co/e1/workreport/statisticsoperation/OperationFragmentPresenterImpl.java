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
      view.showChart();
      view.hideProgress();
    }, 1000);

  }
}
