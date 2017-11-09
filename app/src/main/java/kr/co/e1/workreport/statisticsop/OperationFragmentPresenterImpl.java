package kr.co.e1.workreport.statisticsop;

import android.os.Bundle;
import android.os.Handler;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class OperationFragmentPresenterImpl implements OperationFragmentPresenter {

  private View view;

  OperationFragmentPresenterImpl(View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.showProgress();
    view.detailButtonEnabled(false);
    new Handler().postDelayed(() -> {
      view.showChart();
      view.hideProgress();
      view.detailButtonEnabled(true);
    }, 1000);
  }

  @Override public void onClick(int id) {
    if (id == R.id.detail_button) view.navigateToOpDetail();
  }
}
