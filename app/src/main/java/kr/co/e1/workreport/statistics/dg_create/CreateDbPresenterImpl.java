package kr.co.e1.workreport.statistics.dg_create;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.statistics.dg_create.model.CreateDbYear;

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
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == NetworkHelper.REQ_SUCCESS) {
            CreateDbYear year = result.getContent();
            view.setYear(year.getYear(), year.getMaxYear(), year.getMinYear());
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

  @Override public void onOkClick(int year) {
    view.showLoading();
    compositeDisposable.add(network.createWorkCalendarDb(year)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(wResult -> {
          if(wResult.getResult() == NetworkHelper.REQ_SUCCESS) {
            view.showIndefiniteSnakback(wResult.getMsg());
          } else {
            view.showMessage(R.string.error_server_error);
          }
          view.hideLoading();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideLoading();
        }));
  }

  @Override public void onStart() {
    view.setPositiveButtonText(R.string.create);
  }
}
