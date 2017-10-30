package kr.co.e1.workreport.classificationdialog.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 25
 */

public class ClassificationDialogViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.code_textview) TextView codeTextview;
  @BindView(R.id.big_class_textview) TextView bigClassTextview;
  @BindView(R.id.small_class_textview) TextView smallClassTextview;
  @BindView(R.id.description_textview) TextView descriptionTextview;
  @BindView(R.id.checkbox) CheckBox checkBox;
  ClassificationSelectableItem selectableItem;
  OnRecyclerItemClickListener<ClassificationSelectableItem> onRecyclerItemClickListener;
  BaseAdapterView adapterView;

  public ClassificationDialogViewHolder(View itemView) {
    super(itemView);
  }

  @DebugLog @OnClick(R.id.recyclerview_item_container) void onItemClick() {
    checkBox.setChecked(!checkBox.isChecked());
    if (checkBox.isChecked()) onRecyclerItemClickListener.onItemClick(selectableItem);
    adapterView.refresh();
  }
}