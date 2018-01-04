package kr.co.e1.workreport.statistics.dialog_create;

import java.util.Calendar;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class CreateDbPresenterImpl implements CreateDbPresenter {

  private CreateDbPresenter.View view;

  public CreateDbPresenterImpl(CreateDbPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate() {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int maxYear = year + 50;
    int minYear = year - 50;
    view.setYear(year, maxYear, minYear);
  }
}
