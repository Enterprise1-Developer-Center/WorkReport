package kr.co.e1.workreport.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.interfaces.OnDialogClickListener;
import kr.co.e1.workreport.project.adapter.ProjectDialogAdapter;
import kr.co.e1.workreport.project.adapter.ProjectSelectableItem;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 29
 */

public class ProjectDialog extends BaseAlertDialogFragment
    implements ProjectDialogPresenter.View {

  @Inject ProjectDialogAdapter adapter;
  @Inject BaseAdapterView adapterView;
  @Inject ProjectDialogPresenter presenter;
  @Accessors(chain = true) @Setter String selectedCode = "0";

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

  @Accessors(chain = true) @Setter private OnDialogClickListener<ProjectSelectableItem> onDialogClickListener;

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

  @Override public void dismiss(ProjectSelectableItem selectableItem) {
    onDialogClickListener.onDialogClick(selectableItem);
    dismiss();
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
