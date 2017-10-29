package kr.co.e1.workreport.project;

import android.os.Bundle;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 10. 29
 */

public interface ProjectDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void setAdapterDataModel(BaseAdapterDataModel<Project> adapter);

  interface View {

    void setRecyclerView();

    void refresh();
  }
}