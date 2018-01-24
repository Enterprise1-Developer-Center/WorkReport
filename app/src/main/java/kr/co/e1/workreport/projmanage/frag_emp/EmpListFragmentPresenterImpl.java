package kr.co.e1.workreport.projmanage.frag_emp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;
import kr.co.e1.workreport.projmanage.frag_emp.network.EmpListNetwork;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class EmpListFragmentPresenterImpl implements EmpListFragmentPresenter {

  private EmpListFragmentPresenter.View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private EmpListNetwork network;
  private BaseAdapterDataModel<Employee> adapterDataModel;

  public EmpListFragmentPresenterImpl(EmpListFragmentPresenter.View view, EmpListNetwork network,
      BaseAdapterDataModel<Employee> adapterDataModel) {
    this.view = view;
    this.network = network;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate() {
    view.setRecyclerView();
    view.showProgress();
    compositeDisposable.add(network.getEmployees()
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

  @Override public void onComplete() {
    view.showProgress();
    view.removeRefresh();
    adapterDataModel.clear();
    compositeDisposable.add(network.getEmployees()
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
}