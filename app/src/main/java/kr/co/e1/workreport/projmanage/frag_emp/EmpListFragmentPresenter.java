package kr.co.e1.workreport.projmanage.frag_emp;

import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2018. 1. 12
 */

public interface EmpListFragmentPresenter {

  void onActivityCreate();

  void onComplete();

  interface View {

    void setRecyclerView();
    void showMessage(@StringRes int resId);

    void refresh();

    void removeRefresh();

    void showMessage(String msg);

  }
}
