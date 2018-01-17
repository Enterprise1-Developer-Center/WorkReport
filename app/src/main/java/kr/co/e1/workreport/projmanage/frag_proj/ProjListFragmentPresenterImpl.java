package kr.co.e1.workreport.projmanage.frag_proj;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.main.dg_proje.vo.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.projmanage.frag_proj.network.ProjListNetwork;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class ProjListFragmentPresenterImpl implements ProjListFragmentPresenter {

  private ProjListFragmentPresenter.View view;
  private ProjListNetwork network;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private BaseAdapterDataModel<Project> adapterDataModel;

  public ProjListFragmentPresenterImpl(ProjListFragmentPresenter.View view, ProjListNetwork network,
      BaseAdapterDataModel adapterDataModel) {
    this.view = view;
    this.network = network;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate() {
    view.setRecyclerView();
    compositeDisposable.add(network.getProjects2()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(results -> {
          if (results.getResult() == NetworkHelper.RESULT_SUCCESS) {
            adapterDataModel.addAll(results.getContent());
            view.refresh();
          } else {
            view.showMessage(R.string.error_server_error);
          }
        }, throwable -> view.showMessage(R.string.error_server_error)));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onAddProjComplete() {
    adapterDataModel.clear();
    view.removeRefresh();
    compositeDisposable.add(network.getProjects2()
        .subscribeOn(Schedulers.io())
        .delay(200, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(results -> {
          if (results.getResult() == NetworkHelper.RESULT_SUCCESS) {
            adapterDataModel.addAll(results.getContent());
            view.refresh();
          } else {
            view.showMessage(R.string.error_server_error);
          }
        }, throwable -> view.showMessage(R.string.error_server_error)));
  }

  @Override public void onEditProjComplete() {
    adapterDataModel.clear();
    view.removeRefresh();
    compositeDisposable.add(network.getProjects2()
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
        }, throwable -> view.showMessage(throwable.getMessage())));
  }
}
