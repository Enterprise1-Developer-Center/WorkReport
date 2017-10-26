package kr.co.e1.workreport.classificationcode;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.WindowManager;
import butterknife.BindView;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationcode.adapter.ClassificationAdapter;
import kr.co.e1.workreport.classificationcode.adapter.SelectableItem;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationCodeActivity extends BaseActivity
    implements ClassificationCodePresenter.View, OnRecyclerItemClickListener<SelectableItem> {

  @Inject ClassificationCodePresenter presenter;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_classification;
  }

  @Override protected int getTitleResId() {
    return R.string.classification_code;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return true;
  }

  @Inject ClassificationAdapter adapter;
  @Inject BaseAdapterView adapterView;

  @Override public void setRecyclerView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    Timber.d("adapterView = " + adapterView);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    onBackPressed();
    return true;
  }

  @Override public void onBackPressed() {
    //super.onBackPressed();
    presenter.onBackPressed();
  }

  @DebugLog @Override public void onItemClick(SelectableItem item) {

  }
}