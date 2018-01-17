package kr.co.e1.workreport.projmanage.frag_proj;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.framework.interfaces.OnCompleteListener;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.projmanage.frag_proj.adapter.ProjListAdapter;
import kr.co.e1.workreport.projmanage.frag_proj.adapter.ProjListAdapterView;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.AddProjDialog;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.EditProjDialog;
import kr.co.e1.workreport.projmanage.listener.OnAddClickListener;
import lombok.Getter;

/**
 * Created by jaeho on 2018. 1. 12
 */

public class ProjListFragment extends BaseFragment
    implements ProjListFragmentPresenter.View, OnAddClickListener,
    OnRecyclerItemClickListener<Project> {
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @Inject @Getter ProjListAdapter adapter;
  @Inject ProjListAdapterView adapterView;
  @Inject ProjListFragmentPresenter presenter;

  public static ProjListFragment newInstance() {
    Bundle args = new Bundle();
    ProjListFragment fragment = new ProjListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_proj_manage_proj_list;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate();
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public void setRecyclerView() {
    LinearLayoutManager layout = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layout);
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
    recyclerView.getItemAnimator().setRemoveDuration(Constants.ANI_DURATION);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void removeRefresh() {
    adapterView.refreshRemove();
  }

  @Override public void onDetach() {
    super.onDetach();
    presenter.onDetach();
  }

  @Override public void onAddClick() {
    new AddProjDialog().setOnCompleteListener(new OnCompleteListener() {
      @Override public void onComplete() {
        presenter.onAddProjComplete();
      }
    }).show(getFragmentManager(), AddProjDialog.class.getSimpleName());
  }

  @Override public void onItemClick(Project item) {
    new EditProjDialog().setProject(item).setOnCompleteListener(new OnCompleteListener() {
      @Override public void onComplete() {
        presenter.onEditProjComplete();
      }
    }).show(getFragmentManager(), EditProjDialog.class.getSimpleName());
  }

}
