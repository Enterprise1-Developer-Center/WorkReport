package kr.co.e1.workreport.project;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.project.adapter.ProjectAdapterDataModel;
import kr.co.e1.workreport.project.vo.Project;

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
    compositeDisposable.add(network.getProjects()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<WResult<List<Project>>>() {
          @DebugLog @Override public void accept(WResult<List<Project>> result) throws Exception {
            if (result.getResult() == NetworkHelper.RESULT_SUCCESS) {
              adapterDataModel.addAll(result.getContent());
              view.refresh();
            } else {

            }
          }
        }, new Consumer<Throwable>() {
          @DebugLog @Override public void accept(Throwable throwable) throws Exception {

          }
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onPositiveClick() {
    adapterDataModel.getSelectedItem();
    view.dismiss(adapterDataModel.getSelectedItem());
  }
}