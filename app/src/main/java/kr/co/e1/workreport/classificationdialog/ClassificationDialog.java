package kr.co.e1.workreport.classificationdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.adapter.SelectableItem;
import kr.co.e1.workreport.classificationdialog.adapter.ClassificationDialogAdapter;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 26
 */

public class ClassificationDialog extends BaseAlertDialogFragment
    implements ClassificationDialogPresenter.View, OnRecyclerItemClickListener<SelectableItem> {
  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  @Inject ClassificationDialogPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return R.layout.content_classification;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.classification_code;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return null;
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }

  @Inject ClassificationDialogAdapter adapter;
  private BaseAdapterView adapterView;

  @Override public void setRecyclerView() {
    presenter.setAdapterDataModel(adapter);
    adapterView = adapter;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    if (adapterView != null) {
      adapterView.refresh();
    }
  }

  @Override public void onItemClick(SelectableItem item) {

  }
}
