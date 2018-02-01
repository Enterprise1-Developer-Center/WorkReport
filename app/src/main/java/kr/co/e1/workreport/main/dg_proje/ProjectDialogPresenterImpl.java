package kr.co.e1.workreport.main.dg_proje;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.main.dg_proje.adapter.ProjectAdapterDataModel;
import kr.co.e1.workreport.main.dg_proje.network.ProjectNetwork;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialogPresenterImpl implements ProjectDialogPresenter {

  private ProjectDialogPresenter.View view;
  private ProjectAdapterDataModel adapterDataModel;
  private ProjectNetwork network;

  @Inject ProjectDialogPresenterImpl(ProjectDialogPresenter.View view,
      ProjectAdapterDataModel adapterDataModel, ProjectNetwork network) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
    this.network = network;
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();
    view.showProgress();
    compositeDisposable.add(network.getProjects()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            adapterDataModel.addAll(result.getContent());
            view.refresh();
          } else {

          }

          view.hideProgress();
        }, new Consumer<Throwable>() {
          @DebugLog @Override public void accept(Throwable throwable) throws Exception {
            view.hideProgress();
            view.showMessage(R.string.error_server_error);
          }
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onPositiveClick() {

    view.dismiss(adapterDataModel.getSelectedItem());
  }
}