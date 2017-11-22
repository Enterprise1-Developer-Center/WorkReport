package kr.co.e1.workreport.statisticsop;

import android.os.Bundle;
import android.support.annotation.StringRes;

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

    void showChart();

    void detailButtonEnabled(boolean enabled);

    void navigateToOpDetail();

    void showMessage(@StringRes int resId);

    void showYearOpRatioChart();

    void showMemberOpRatioChart();
  }
}
