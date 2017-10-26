package kr.co.e1.workreport.classificationdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.adapter.ClassificationDialogAdapter;
import kr.co.e1.workreport.classificationdialog.adapter.SelectableItem;
import kr.co.e1.workreport.classificationdialog.vo.SimpleClassificationCode;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.ObjectUtils;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 26
 */

public class ClassificationDialog extends BaseAlertDialogFragment
    implements ClassificationDialogPresenter.View, OnRecyclerItemClickListener<SelectableItem> {
  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @BindView(R.id.text_input_edittext) TextInputEditText workTextInputEditText;
  @Inject ClassificationDialogPresenter presenter;

  OnDialogClickListener<SimpleClassificationCode> onDialogClickListener;

  public ClassificationDialog setOnDialogClickListener(
      OnDialogClickListener<SimpleClassificationCode> listener) {
    onDialogClickListener = listener;
    return this;
  }

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
    return (dialogInterface, witch) -> {
      String code = ObjectUtils.isEmpty(workTextInputEditText.getTag()) ? ""
          : workTextInputEditText.getTag().toString();
      String work = workTextInputEditText.getText().toString().trim();
      onDialogClickListener.onClick(new SimpleClassificationCode(code, work));
    };
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
    workTextInputEditText.setTag(item.getClassificationCode().getCode());
  }
}
