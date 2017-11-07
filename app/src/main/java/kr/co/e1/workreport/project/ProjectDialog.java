package kr.co.e1.workreport.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import kr.co.e1.workreport.framework.interfaces.OnDialogClickListener;
import kr.co.e1.workreport.project.adapter.ProjectDialogAdapter;
import kr.co.e1.workreport.project.adapter.ProjectSelectableItem;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialog extends BaseAlertDialogFragment
    implements ProjectDialogPresenter.View, OnRecyclerItemClickListener<ProjectSelectableItem> {

  @Inject ProjectDialogAdapter adapter;
  @Inject ProjectDialogPresenter presenter;
  @Inject BaseAdapterView adapterView;

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  OnDialogClickListener<Bundle> onDialogClickListener;

  public ProjectDialog setOnDialogClickListener(OnDialogClickListener<Bundle> listener) {
    onDialogClickListener = listener;
    return this;
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_project;
  }

  @Override protected ViewGroup getInflateRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.project_name;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      onDialogClickListener.onDialogClick(bundle);
      dismiss();
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      dismiss();
    };
  }

  private Bundle bundle = new Bundle();

  @DebugLog @Override public void onItemClick(ProjectSelectableItem selectableItem) {
    bundle.putString("name", selectableItem.getItem().getName());
  }

  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }
}
