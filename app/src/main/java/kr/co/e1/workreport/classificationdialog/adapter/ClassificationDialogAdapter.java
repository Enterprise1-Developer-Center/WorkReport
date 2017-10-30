package kr.co.e1.workreport.classificationdialog.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationDialogAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<ClassificationCode>, BaseAdapterView,
    OnRecyclerItemClickListener<ClassificationSelectableItem> {

  private ArrayList<ClassificationCode> items = new ArrayList<>();
  private ArrayList<ClassificationSelectableItem> selectableItems = new ArrayList<>();

  private OnRecyclerItemClickListener<ClassificationSelectableItem> onRecyclerItemClickListener;

  @Inject public ClassificationDialogAdapter(OnRecyclerItemClickListener listener) {
    this.onRecyclerItemClickListener = listener;
  }

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new ClassificationDialogViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.dialog_classification_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof ClassificationDialogViewHolder) {
      ClassificationDialogViewHolder holder = (ClassificationDialogViewHolder) viewHolder;
      ClassificationSelectableItem item = selectableItems.get(position);
      ClassificationCode classCode = item.getItem();
      holder.selectableItem = selectableItems.get(position);
      holder.codeTextview.setText(classCode.getCode());
      holder.bigClassTextview.setText(classCode.getBigClass());
      holder.smallClassTextview.setText(classCode.getSmallClass());
      holder.descriptionTextview.setText(classCode.getDescription());
      holder.checkBox.setChecked(item.isSelected());
      holder.checkBox.setEnabled(false);
      holder.onRecyclerItemClickListener = this;
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }

  public void refresh(int position) {
    notifyItemChanged(position);
  }

  @Override public void add(ClassificationCode item) {
    items.add(item);
    selectableItems.add(new ClassificationSelectableItem(item, false));
  }

  @Override public void addAll(List<ClassificationCode> items) {
    items.addAll(items);
  }

  @Override public ClassificationCode remove(int position) {
    return items.remove(position);
  }

  @Override public ClassificationCode getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, ClassificationCode item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
    selectableItems.clear();
  }

  private int prePosition;

  @Override public void onItemClick(ClassificationSelectableItem item) {
    for (ClassificationSelectableItem selectableItem : selectableItems) {
      if (!selectableItem.equals(item)) {
        selectableItem.setSelected(false);
      } else {
        selectableItem.setSelected(true);
      }
    }

    refresh(prePosition);
    prePosition = selectableItems.indexOf(item);
    onRecyclerItemClickListener.onItemClick(item);
  }
}