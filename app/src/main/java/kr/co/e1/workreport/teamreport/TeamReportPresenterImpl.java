package kr.co.e1.workreport.teamreport;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.teamreport.model.TeamReportContent;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportPresenterImpl implements TeamReportPresenter {
  private TeamReportPresenter.View view;
  private BaseAdapterDataModel<TeamReportContent> adapterDataModel;
  private TeamReportNetwork network;

  TeamReportPresenterImpl(TeamReportPresenter.View view,
      BaseAdapterDataModel<TeamReportContent> adapterDataModel, TeamReportNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onCreated(Bundle savedInstanceState) {
    view.setRecyclerView();
    view.showProgress();
    compositeDisposable.add(network.getSummary()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<WResult<List<TeamReportContent>>>() {
          @Override public void accept(WResult<List<TeamReportContent>> result) throws Exception {
            if (result.getResult() == WResult.RESULT_SUCCESS) {
              adapterDataModel.addAll(result.getContent());
              view.refresh();
            } else {

            }
            view.hideProgress();
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(Throwable throwable) throws Exception {

            view.hideProgress();
          }
        }));
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}