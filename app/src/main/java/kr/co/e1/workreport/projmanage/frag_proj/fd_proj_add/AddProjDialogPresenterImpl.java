package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import java.util.Calendar;
import java.util.Locale;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.utils.DateUtils;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddProjDialogPresenterImpl implements AddProjDialogPresenter {

  private AddProjDialogPresenter.View view;

  public AddProjDialogPresenterImpl(AddProjDialogPresenter.View view) {
    this.view = view;
  }

  @Override public void onClick(int id) {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    switch (id) {
      case R.id.start_date_edittext:
        view.showStartDatePickerDialog(year, month, day);
        break;
      case R.id.end_date_edittext:
        view.showEndDatePickerDialog(year, month, day);
        break;
      case R.id.dept_cd_edittext:

        break;
    }
  }

  @Override public void onStartDateSet(int year, int month, int day) {
    view.showStartDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd (EEE)", Locale.KOREA));
  }

  @Override public void onEndDateSet(int year, int month, int day) {
    view.showEndDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd (EEE)", Locale.KOREAN));
  }
}