package kr.co.e1.workreport.teamreport;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportPresenterImpl implements TeamReportPresenter {
  private TeamReportPresenter.View view;

  TeamReportPresenterImpl(TeamReportPresenter.View view) {
    this.view = view;
  }

  @Override public void onCreated(Bundle savedInstanceState) {

  }
}
