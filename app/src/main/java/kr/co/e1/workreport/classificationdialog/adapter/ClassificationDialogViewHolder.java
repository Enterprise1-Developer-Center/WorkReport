package kr.co.e1.workreport.classificationdialog.adapter;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 25
 */

public class ClassificationDialogViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.code_textview) TextView codeTextview;
  @BindView(R.id.big_class_textview) TextView bigClassTextview;
  @BindView(R.id.small_class_textview) TextView smallClassTextview;
  @BindView(R.id.description_textview) TextView descriptionTextview;
  @BindView(R.id.recyclerview_item_container) View containerView;

  ClassificationSelectableItem selectableItem;
  OnRecyclerItemClickListener<ClassificationSelectableItem> onRecyclerItemClickListener;

  public ClassificationDialogViewHolder(View itemView) {
    super(itemView);
  }

  @OnClick(R.id.recyclerview_item_container) void onItemClick(View view) {
    if (!selectableItem.isSelected()) {
      selectableItem.setSelected(!selectableItem.isSelected());
      view.setBackgroundColor(
          ContextCompat.getColor(itemView.getContext(), R.color.colorIndigo_200));
      onRecyclerItemClickListener.onItemClick(selectableItem);
    }
  }
}