package kr.co.e1.workreport.statistics.fm_holiday;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;
import kr.co.e1.workreport.statistics.fm_holiday.network.HolidayNetwork;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class HolidayFragmentPresenterImpl implements HolidayFragmentPresenter {

  private View view;
  private HolidayNetwork network;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private BaseAdapterDataModel<Holiday> adapterDataModel;

  public HolidayFragmentPresenterImpl(View view, HolidayNetwork network,
      BaseAdapterDataModel<Holiday> adapterDataModel) {
    this.view = view;
    this.network = network;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate(Bundle args) {
    view.setRecyclerView();
    view.showProgress();
    compositeDisposable.add(network.getHolidays(args.getInt("year"))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(results -> {
          if (results.getResult() == NetworkHelper.RESULT_SUCCESS) {
            adapterDataModel.addAll(results.getContent());
            view.refresh();
          } else {
            view.showMessage(results.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(throwable.getMessage());
          view.hideProgress();
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onComplete() {
    view.showProgress();
    view.removeRefresh();
    adapterDataModel.clear();
    compositeDisposable.add(network.getHolidays(2017)
        .subscribeOn(Schedulers.io())
        .delay(200, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(results -> {
          if (results.getResult() == NetworkHelper.RESULT_SUCCESS) {
            adapterDataModel.addAll(results.getContent());
            view.refresh();
          } else {
            view.showMessage(results.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(throwable.getMessage());
          view.hideProgress();
        }));
  }

  @Override public void onItemClick(final Holiday item) {

  }

  @Override public void onFabClick() {
    view.showAddHolidayDialog();
  }
}