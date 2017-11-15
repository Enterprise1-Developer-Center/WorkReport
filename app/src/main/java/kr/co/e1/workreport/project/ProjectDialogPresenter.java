package kr.co.e1.workreport.project;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 29
 */

public interface ProjectDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onDetach();

  interface View {

    void setRecyclerView();

    void refresh();
  }
}