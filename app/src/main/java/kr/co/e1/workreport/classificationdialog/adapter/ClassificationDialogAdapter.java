package kr.co.e1.workreport.classificationdialog.adapter;

import android.support.v4.content.ContextCompat;
import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationDialogAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<ClassificationCode>, BaseAdapterView,
    OnRecyclerItemClickListener<ClassificationSelectableItem> {

  private ArrayList<ClassificationCode> items = new ArrayList<>();
  private ArrayList<ClassificationSelectableItem> selectableItems = new ArrayList<>();

  @Accessors(chain = true) @Setter private OnRecyclerItemClickListener<ClassificationSelectableItem>
      onRecyclerItemClickListener;

  @Accessors(chain = true) @Setter private int selectedCode;

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
      holder.codeTextview.setText(String.valueOf(classCode.getSmallClassCode()));
      holder.bigClassTextview.setText(classCode.getMajorClassName());
      holder.smallClassTextview.setText(classCode.getSmallClassName());
      holder.descriptionTextview.setText(classCode.getClassDesc());
      holder.onRecyclerItemClickListener = this;
      if (item.isSelected()) {
        holder.containerView.setBackgroundColor(
            ContextCompat.getColor(holder.codeTextview.getContext(), R.color.colorIndigo_200));
      } else {
        holder.containerView.setBackgroundColor(
            ContextCompat.getColor(holder.codeTextview.getContext(), android.R.color.transparent));
      }
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @DebugLog @Override public void refresh() {
    for (int i = 0; i < items.size(); i++) {
      refresh(i);
    }
  }

  public void refresh(int position) {
    notifyItemChanged(position);
  }

  @Override public void add(ClassificationCode item) {
    items.add(item);
  }

  @DebugLog @Override public void addAll(List<ClassificationCode> items) {
    this.items.addAll(items);
    for (int i = 0; i < items.size(); i++) {
      ClassificationCode item = items.get(i);
      boolean isSelected = false;
      if (item.getSmallClassCode() == selectedCode) {
        isSelected = true;
        prePosition = i;
      }
      selectableItems.add(new ClassificationSelectableItem(item, isSelected));
    }
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