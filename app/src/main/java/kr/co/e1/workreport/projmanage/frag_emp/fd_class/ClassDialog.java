package kr.co.e1.workreport.projmanage.frag_emp.fd_class;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.OnClassItemClickListener;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 26
 */

public class ClassDialog extends BaseAlertDialogFragment implements DialogInterface {

  @BindView(R.id.recyclerview) RecyclerView recyclerview;
  @BindView(R.id.text_input_edittext) TextInputEditText textInputEdittext;
  @BindView(R.id.text_input_layout) TextInputLayout textInputLayout;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) FrameLayout rootView;
  @Accessors(chain = true) @Setter private OnClassItemClickListener onItemClickListener;
  @Accessors(chain = true) @Setter List<DetailWork> items;
  @Accessors(chain = true) @Setter int checkedItem;

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return false;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return null;
  }

  @Override protected boolean isDagger() {
    return false;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    goneLayout();
    setRecyclerView();
  }

  private void goneLayout() {
    textInputEdittext.setVisibility(View.GONE);
    textInputLayout.setVisibility(View.GONE);
    progressBar.setVisibility(View.GONE);
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_classification;
  }

  @Override protected int getTitle() {
    return R.string.empty_text;
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  private void setRecyclerView() {
    recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerview.getItemAnimator().setChangeDuration(Constants.ANI_DURATION);
    ClassDialogAdapter adapter = new ClassDialogAdapter();
    adapter.setOnRecyclerItemClickListener(item -> {
      onItemClickListener.onClassItemClick(item, this);
    });
    adapter.setCheckedItem(checkedItem);
    adapter.addAll(items);
    recyclerview.setAdapter(adapter);
  }

  @Override public void cancel() {
    // nothing
  }
}
