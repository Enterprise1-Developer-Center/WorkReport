package kr.co.e1.workreport.project;

import android.os.Bundle;
import kr.co.e1.workreport.project.adapter.ProjectSelectableItem;

/**
 * Created by jaeho on 2017. 10. 29
 */

public interface ProjectDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onDetach();

  void onPositiveClick();

  interface View {

    void setRecyclerView();

    void refresh();

    void dismiss(ProjectSelectableItem selectableItem);
  }
}