package kr.co.e1.workreport.statisticsop;

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

    void detailButtonEnabled(boolean enabled);
  }
}
