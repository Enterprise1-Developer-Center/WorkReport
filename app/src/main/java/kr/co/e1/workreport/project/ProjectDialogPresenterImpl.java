package kr.co.e1.workreport.project;

import android.os.Bundle;
import javax.inject.Inject;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialogPresenterImpl implements ProjectDialogPresenter {

  private ProjectDialogPresenter.View view;
  private BaseAdapterDataModel<Project> adapterDataModel;

  @Inject ProjectDialogPresenterImpl(ProjectDialogPresenter.View view,
      BaseAdapterDataModel<Project> adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();

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

    view.refresh();
  }
}