package kr.co.e1.workreport.project;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialogPresenterImpl implements ProjectDialogPresenter {

  private ProjectDialogPresenter.View view;
  private BaseAdapterDataModel<Project> adapterDataModel;
  private ProjectNetwork network;

  @Inject ProjectDialogPresenterImpl(ProjectDialogPresenter.View view,
      BaseAdapterDataModel<Project> adapterDataModel, ProjectNetwork network) {
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
            if(result.getResult() == NetworkHelper.RESULT_SUCCESS) {
              adapterDataModel.addAll(result.getContent());
              view.refresh();
            } else {

            }
          }
        }, new Consumer<Throwable>() {
          @DebugLog @Override public void accept(Throwable throwable) throws Exception {

          }
        })
    );

    /*
    adapterDataModel.add(new Project(0, "동물농장"));
    adapterDataModel.add(new Project(1, "1984"));
    adapterDataModel.add(new Project(2, "일리아스"));
    adapterDataModel.add(new Project(3, "열하일기"));
    adapterDataModel.add(new Project(4, "이방인"));
    adapterDataModel.add(new Project(5, "데미안"));
    adapterDataModel.add(new Project(6, "참을 수 없는 존재의 가벼움"));
    adapterDataModel.add(new Project(7, "고구려는 천자 제국이었다"));
    adapterDataModel.add(new Project(8, "반구대"));
    adapterDataModel.add(new Project(9, "군주론"));
    adapterDataModel.add(new Project(10, "인간관계론"));
    adapterDataModel.add(new Project(11, "데일카네기"));
    adapterDataModel.add(new Project(12, "링컨"));
    adapterDataModel.add(new Project(13, "루즈벨드"));
    adapterDataModel.add(new Project(14, "김형석"));
    adapterDataModel.add(new Project(15, "김수환"));
    */

    view.refresh();
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}