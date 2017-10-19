package kr.co.e1.workreport.report;

import android.os.Bundle;
import javax.inject.Inject;

/**
 * Created by jaeho on 2017. 10. 19
 */

public class ReportFragmentPresenterImpl implements ReportFragmentPresenter {

  private ReportFragmentPresenter.View view;

  @Inject ReportFragmentPresenterImpl(ReportFragmentPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {

  }
}
