package kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday;

import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.network.EditHolidayNetwork;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;
import kr.co.e1.workreport.statistics.fm_holiday.model.LegalHoliday;
import timber.log.Timber;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class EditHolidayDialogPresenterImpl implements EditHolidayDialogPresenter {

  private EditHolidayDialogPresenter.View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private EditHolidayNetwork network;

  public EditHolidayDialogPresenterImpl(EditHolidayDialogPresenter.View view,
      EditHolidayNetwork network) {
    this.view = view;
    this.network = network;
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @DebugLog @Override public void onEditClick(String $date, String name) {
    view.setButtonEnabled(false);
    String date = DateUtils.convertStringToFormatString($date, "yyyy-MM-dd (EEEE)", "yyyyMMdd", Locale.KOREA);
    Timber.d("date = " + date + ", name = " + name);
    compositeDisposable.add(network.editHoliday(date, name)
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

  @Override public void onActivityCreate(Holiday holiday) {
    String date =
        DateUtils.convertStringToFormatString(holiday.getYmd(), "yyyyMMdd", "yyyy-MM-dd (EEEE)",
            Locale.KOREA);
    view.showDate(date);
    view.showHolidayName(holiday.getName());
    view.disableLayout();
  }

  @DebugLog @Override public void onDelClick(String $date) {
    view.setButtonEnabled(false);
    String date = DateUtils.convertStringToFormatString($date, "yyyy-MM-dd (EEEE)", "yyyyMMdd");
    Timber.d("date = " + date);
    compositeDisposable.add(network.delHoliday(date)
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

  @Override public void onHolidayNameEditTextClick(final String name) {
    compositeDisposable.add(network.getLegalHolidays()
        .subscribeOn(Schedulers.io())
        .map(result -> LegalHoliday.convertToNameArray(result.getContent()))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(items -> {
          int checkedItem = LegalHoliday.indexOf(name, items);
          view.showNameChoiceDialog(items, checkedItem, (dialogInterface, which) -> {
            view.showHolidayName(items[which]);
            dialogInterface.dismiss();
          });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }
}