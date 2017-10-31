package kr.co.e1.workreport.classificationcode;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
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
  @BindView(R.id.text_input_edittext) TextInputEditText workTextInputEditText;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreated(savedInstanceState);
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

  @Override protected boolean isDagger() {
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

  public final static String WORK_INTENT_NAME = "work";

  @Override public void finishActivity() {
    getIntent().putExtra(WORK_INTENT_NAME, workTextInputEditText.getText().toString().trim());
    setResult(RESULT_OK, getIntent());
    Timber.d("finishActivity code = " + getIntent().getStringExtra("code"));
    finish();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    onBackPressed();
    return true;
  }

  @Override public void onBackPressed() {
    presenter.onBackPressed();
  }

  public final static String CODE_INTENT_NAME = "code";

  @DebugLog @Override public void onItemClick(SelectableItem item) {
    getIntent().putExtra(CODE_INTENT_NAME, item.getClassificationCode().getCode());
  }
}