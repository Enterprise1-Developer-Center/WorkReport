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
  }
}
