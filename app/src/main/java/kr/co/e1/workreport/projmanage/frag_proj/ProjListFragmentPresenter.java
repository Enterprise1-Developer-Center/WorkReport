package kr.co.e1.workreport.projmanage.frag_proj;

import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2018. 1. 12
 */

public interface ProjListFragmentPresenter {

  void onActivityCreate();

  void onDetach();

  interface View {

    void setRecyclerView();

    void showMessage(@StringRes int resId);

    void refresh();
  }
}
