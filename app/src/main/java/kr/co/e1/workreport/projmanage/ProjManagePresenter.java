package kr.co.e1.workreport.projmanage;

import android.support.v4.app.Fragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public interface ProjManagePresenter {

  void onCreated();

  void onFabClick(Fragment item);

  interface View {

    void setViewPager();

    void setTabLayout();
  }
}
