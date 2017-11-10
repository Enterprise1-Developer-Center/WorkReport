package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.statisticstotal.adapter.TotalAdapter;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {

  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Inject TotalAdapter adapter;
  @Inject TotalFragmentPresenter presenter;
  @Inject BaseAdapterView adapterView;

  public static TotalFragment newInstance() {
    return new TotalFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_total;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    final LayoutAnimationController controller =
        AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_fall_down);
    recyclerView.setLayoutAnimation(controller);
    adapterView.refresh();
    recyclerView.scheduleLayoutAnimation();
  }

  @OnClick({ R.id.detail_button }) void onClick(View view) {
    presenter.onClick(view.getId());
  }
}
