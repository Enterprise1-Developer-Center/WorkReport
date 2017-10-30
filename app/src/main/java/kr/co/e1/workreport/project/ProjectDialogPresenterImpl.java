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

  @Inject ProjectDialogPresenterImpl(ProjectDialogPresenter.View view) {
    this.view = view;
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
    adapterDataModel.add(new Project(7, "백년을 살아보니"));
    adapterDataModel.add(new Project(0, "동물농장"));
    adapterDataModel.add(new Project(1, "1984"));
    adapterDataModel.add(new Project(2, "일리아스"));
    adapterDataModel.add(new Project(3, "열하일기"));
    adapterDataModel.add(new Project(4, "이방인"));
    adapterDataModel.add(new Project(5, "데미안"));
    adapterDataModel.add(new Project(6, "참을 수 없는 존재의 가벼움"));
    adapterDataModel.add(new Project(7, "백년을 살아보니"));

    view.refresh();
  }

  @Override public void setAdapterDataModel(BaseAdapterDataModel<Project> adapterDataModel) {
    this.adapterDataModel = adapterDataModel;
  }
}