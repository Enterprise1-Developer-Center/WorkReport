package kr.co.e1.workreport.main.dialog_class;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.main.dialog_class.adapter.ClassificationDialogAdapter;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.interfaces.OnDialogClickListener;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 26
 */

public class ClassificationDialog extends BaseAlertDialogFragment
    implements ClassificationDialogPresenter.View {
  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @BindView(R.id.text_input_edittext) TextInputEditText workTextInputEditText;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;

  @Inject ClassificationDialogAdapter adapter;
  @Inject BaseAdapterView adapterView;
  @Inject ClassificationDialogPresenter presenter;

  @Accessors(chain = true) @Setter private OnDialogClickListener<DetailWork>
      onDialogClickListener;
  @Accessors(chain = true) @Setter DetailWork nowDetailWork;
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
    presenter.onActivityCreate(savedInstanceState, nowDetailWork);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_classification;
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
      String work = workTextInputEditText.getText().toString().trim();
      presenter.onPositiveClick(work);
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    if (adapterView != null) {
      adapterView.refresh();
    }
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showWork(String work) {
    workTextInputEditText.setText(work);
  }

  @Override public void dismiss(DetailWork detailWork) {
    onDialogClickListener.onDialogClick(detailWork);
    dismiss();
  }
}
