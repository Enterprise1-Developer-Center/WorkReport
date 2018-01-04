package kr.co.e1.workreport.statistics.dialog_create;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.NetworkHelper;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class CreateDbPresenterImpl implements CreateDbPresenter {

  private CreateDbPresenter.View view;
  private CreateDbNetwork network;
  private CompositeDisposable compositeDisposable;

  public CreateDbPresenterImpl(CreateDbPresenter.View view, CreateDbNetwork network) {
    this.view = view;
    this.network = network;
    this.compositeDisposable = new CompositeDisposable();
  }

  @Override public void onActivityCreate() {
    view.showLoading();
    compositeDisposable.add(network.getCreateDbYear()
        .subscribeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == NetworkHelper.REQ_SUCCESS) {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int minYear = year - result.getContent().getMinValue();
            int maxYear = year + result.getContent().getMaxValue();
            view.setYear(year, maxYear, minYear);
          } else {
            view.showMessage(R.string.error_server_error);
          }
          view.hideLoading();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideLoading();
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}
