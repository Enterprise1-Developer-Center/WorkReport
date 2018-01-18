package kr.co.e1.workreport.projmanage;

import android.support.v4.app.Fragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public interface ProjManagePresenter {

  void onCreated();

  void onFabClick(Fragment item);

  void onTabSelected(int position);

  interface View {

    void setTabLayout();

    void showProjListFragment();

    void showEmpListFragment();
  }
}
