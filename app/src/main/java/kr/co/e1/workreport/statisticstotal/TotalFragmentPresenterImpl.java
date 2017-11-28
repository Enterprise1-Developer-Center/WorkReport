package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class TotalFragmentPresenterImpl implements TotalFragmentPresenter {

  private View view;
  private BaseAdapterDataModel<TotalSummary> adapterDataModel;
  private TotalNetwork network;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  TotalFragmentPresenterImpl(View view, BaseAdapterDataModel adapterDataModel,
      TotalNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.showProgress();
    view.setRecyclerView();

    compositeDisposable.add(network.getWorkingDayTOT()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            adapterDataModel.addAll(result.getContent());
            view.refresh();
          } else {
            view.showMessage(result.getMsg());
          }
          view.hideProgress();
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        }));
  }

  @Override public void onClick(int id) {
    if (id == R.id.detail_button) view.showMessage(R.string.coming_soon);
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}
