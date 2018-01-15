package kr.co.e1.workreport.projmanage.frag_proj;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.main.dg_proje.vo.Project;
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
        .subscribe(new Consumer<WResult<List<Project>>>() {
          @Override public void accept(WResult<List<Project>> results) throws Exception {
            if (results.getResult() == NetworkHelper.RESULT_SUCCESS) {
              adapterDataModel.addAll(results.getContent());
              view.refresh();
            } else {
              view.showMessage(R.string.error_server_error);
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(Throwable throwable) throws Exception {
            view.showMessage(R.string.error_server_error);
          }
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}
