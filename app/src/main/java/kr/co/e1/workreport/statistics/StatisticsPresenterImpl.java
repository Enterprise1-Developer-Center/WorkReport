package kr.co.e1.workreport.statistics;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class StatisticsPresenterImpl implements StatisticsPresenter {

  private StatisticsPresenter.View view;

  StatisticsPresenterImpl(StatisticsPresenter.View view) {
    this.view = view;
  }

  @Override public void onCreated(Bundle savedInstanceState) {

  }
}