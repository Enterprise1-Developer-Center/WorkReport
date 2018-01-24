package kr.co.e1.workreport.projmanage.frag_proj;

import android.support.annotation.StringRes;
import kr.co.e1.workreport.main.dg_proje.model.Project;

/**
 * Created by jaeho on 2018. 1. 12
 */

public interface ProjListFragmentPresenter {

  void onActivityCreate();

  void onDetach();

  void onComplete();

  void onItemClick(Project item);

  interface View {

    void setRecyclerView();

    void showMessage(@StringRes int resId);

    void refresh();

    void removeRefresh();

    void showMessage(String msg);

    void showEditProjDialog(Project item, String deptName);

    void showProgress();

    void hideProgress();
  }
}
