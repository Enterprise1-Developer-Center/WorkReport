package kr.co.e1.workreport.projmanage.frag_proj;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
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
      BaseAdapterDataModel<Project> adapterDataModel) {
    this.view = view;
    this.network = network;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate() {
    view.setRecyclerView();
    view.showProgress();
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
          view.hideProgress();
        }, throwable -> {
          view.showMessage(throwable.getMessage());
          view.hideProgress();
        }));
  }

  @Override public void onItemClick(final Project item) {
    compositeDisposable.add(network.getDepts()
        .subscribeOn(Schedulers.io())
        .flattenAsObservable(WResult::getContent)
        .filter(dept -> item.getDept_cd().equals(dept.getDept_cd()))
        .toList()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(depts -> {
          if (depts.size() > 0) {
            view.showEditProjDialog(item, depts.get(0).getDept_nm());
          }
        }, throwable -> view.showMessage(throwable.getMessage())));
  }
}
