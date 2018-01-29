package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday;

import android.content.DialogInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.Locale;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.framework.utils.MyTextUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.model.AddHolidayNetModelWrapper;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.model.LegalHoliday;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.network.AddHolidayNetwork;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddHolidayDialogPresenterImpl implements AddHolidayDialogPresenter {

  private AddHolidayDialogPresenter.View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private AddHolidayNetwork network;
  private AddHolidayNetModelWrapper modelWrapper;

  public AddHolidayDialogPresenterImpl(AddHolidayDialogPresenter.View view,
      AddHolidayNetwork network) {
    this.view = view;
    this.network = network;
    this.modelWrapper = new AddHolidayNetModelWrapper();
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onAddClick(String $date, String name) {
    view.setButtonEnabled(false);
    String date = DateUtils.convertStringToFormatString($date, "yyyy-MM-dd (EEEE)", "yyyyMMdd");
    compositeDisposable.add(network.addHoliday(date, name)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(wResult -> {
          if (wResult.getResult() == NetworkHelper.RESULT_SUCCESS) {
            view.showSuccessMessage(wResult.getMsg());
          } else {
            view.showMessage(wResult.getMsg());
          }
          view.setButtonEnabled(true);
        }, throwable -> {
          view.showMessage(throwable.getMessage());
          view.setButtonEnabled(true);
        }));
  }

  @Override public void onHolidayEditTextClick(String date) {
    Calendar cal = Calendar.getInstance();
    int $year = cal.get(Calendar.YEAR);
    int $month = cal.get(Calendar.MONTH);
    int $dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

    if (!MyTextUtils.isBlank(date)) {
      cal.setTime(DateUtils.convertStringToDate(date, "yyyy-MM-dd (EEEE)", Locale.KOREA));
      $year = cal.get(Calendar.YEAR);
      $month = cal.get(Calendar.MONTH);
      $dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
    }

    view.showDatePickerDialog($year, $month, $dayOfMonth, (picker, year, month, dayOfMonth) -> {
      view.showDate(
          DateUtils.getDateString(year, month, dayOfMonth, "yyyy-MM-dd (EEEE)", Locale.KOREA));
    });
  }

  @Override public void onHolidayNameEditTextClick(final String name) {
    compositeDisposable.add(network.getLegalHolidays()
        .subscribeOn(Schedulers.io())
        .map(result -> LegalHoliday.convertToNameArray(result.getContent()))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(items -> {
          int checkedItem = LegalHoliday.indexOf(name, items);
          view.showNameChoiceDialog(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int which) {
              view.showHolidayName(items[which]);
              dialogInterface.dismiss();
            }
          });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }
}