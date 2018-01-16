package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class AddProjDialog extends BaseAlertDialogFragment implements AddProjDialogPresenter.View {

  @BindView(R.id.proj_code_edittext) EditText projCodeEdittext;
  @BindView(R.id.proj_name_edittext) EditText projNameEdittext;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) FrameLayout rootView;
  @BindView(R.id.start_date_edittext) EditText startDateEdittext;
  @BindView(R.id.end_date_edittext) EditText endDateEdittext;
  @BindView(R.id.dept_cd_edittext) EditText deptCdEdittext;

  @Inject AddProjDialogPresenter presenter;

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

  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_project;
  }

  @Override protected int getTitle() {
    return R.string.add_project;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> dismiss();
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @OnClick({ R.id.start_date_edittext, R.id.end_date_edittext, R.id.dept_cd_edittext })
  void onClick(View view) {
    presenter.onClick(view.getId());
  }
}
