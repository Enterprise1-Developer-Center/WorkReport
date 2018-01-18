package kr.co.e1.workreport.projmanage.frag_proj;

import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;
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
        }, throwable -> view.showMessage(throwable.getMessage())));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onAddProjComplete() {
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
            view.showMessage(R.string.error_server_error);
          }
        }, throwable -> view.showMessage(R.string.error_server_error)));
  }

  @Override public void onEditProjComplete() {
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
        }, throwable -> view.showMessage(throwable.getMessage())));
  }

  @Override public void onItemClick(final Project item) {
    compositeDisposable.add(network.getDepts()
        .subscribeOn(Schedulers.io())
        .flattenAsObservable(new Function<WResult<List<Dept>>, Iterable<Dept>>() {
          @Override public Iterable<Dept> apply(WResult<List<Dept>> result) throws Exception {
            return result.getContent();
          }
        })
        .filter(new Predicate<Dept>() {
          @Override public boolean test(Dept dept) throws Exception {
            return item.getDept_cd().equals(dept.getDept_cd());
          }
        })
        .toList()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Dept>>() {
          @DebugLog @Override public void accept(List<Dept> depts) throws Exception {
            if (depts.size() > 0) {
              view.showEditProjDialog(item, depts.get(0).getDept_nm());
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(Throwable throwable) throws Exception {
            view.showMessage(throwable.getMessage());
          }
        }));
  }
}
