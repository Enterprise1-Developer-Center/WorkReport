package kr.co.e1.workreport.projmanage;

import android.support.v4.app.Fragment;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;
import kr.co.e1.workreport.projmanage.listener.OnFabClickListener;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class ProjManagePresenterImpl implements ProjManagePresenter {

  private ProjManagePresenter.View view;

  public ProjManagePresenterImpl(ProjManagePresenter.View view) {
    this.view = view;
  }

  @Override public void onCreated() {
    view.setViewPager();
    view.setTabLayout();
  }

  @Override public void onFabClick(Fragment item) {
    if(item instanceof ProjListFragment || item instanceof EmpListFragment) {
      OnFabClickListener onFabClickListener = (OnFabClickListener) item;
      if (onFabClickListener != null) {
        onFabClickListener.onFabClick();
      }
    }
  }
}
