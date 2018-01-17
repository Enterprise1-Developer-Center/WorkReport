package kr.co.e1.workreport.main.dg_proje;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.interfaces.OnDialogClickListener;
import kr.co.e1.workreport.main.dg_proje.adapter.ProjectDialogAdapter;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialog extends BaseAlertDialogFragment implements ProjectDialogPresenter.View {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @Inject ProjectDialogAdapter adapter;
  @Inject BaseAdapterView adapterView;
  @Inject ProjectDialogPresenter presenter;
  @Accessors(chain = true) @Setter Project nowProject;

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

  @Accessors(chain = true) @Setter private OnDialogClickListener<Project> onDialogClickListener;

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
    return R.string.empty_text;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      presenter.onPositiveClick();
    };
  }

  @Override public void dismiss(Project selectedItem) {
    onDialogClickListener.onDialogClick(selectedItem);
    dismiss();
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(contentView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      dismiss();
    };
  }

  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void onDetach() {
    presenter.onDetach();
    super.onDetach();
  }
}
