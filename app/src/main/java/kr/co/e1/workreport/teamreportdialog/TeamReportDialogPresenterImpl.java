package kr.co.e1.workreport.teamreportdialog;

import javax.inject.Inject;

/**
 * Created by jaeho on 2017. 11. 1
 */

public class TeamReportDialogPresenterImpl implements TeamReportDialogPresenter {

  private TeamReportDialogPresenter.View view;
  @Inject TeamReportDialogPresenterImpl(TeamReportDialogPresenter.View view) {
    this.view = view;
  }
}
