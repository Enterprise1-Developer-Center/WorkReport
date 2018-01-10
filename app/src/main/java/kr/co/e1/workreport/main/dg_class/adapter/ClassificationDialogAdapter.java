package kr.co.e1.workreport.main.dg_class.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationDialogAdapter extends BaseRecyclerAdapter
    implements ClassAdapterDataModel, BaseAdapterView,
    OnRecyclerItemClickListener<DetailSelectableItem> {

  private ArrayList<DetailWork> items = new ArrayList<>();
  private ArrayList<DetailSelectableItem> selectableItems = new ArrayList<>();
  private DetailWork nowDetailWork;

  public ClassificationDialogAdapter(DetailWork nowDetailWork) {
    this.nowDetailWork = nowDetailWork;
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
      Context context = holder.itemView.getContext();
      DetailSelectableItem item = selectableItems.get(position);
      DetailWork classCode = item.getItem();
      holder.selectableItem = selectableItems.get(position);
      holder.codeTextview.setText(String.valueOf(classCode.getMcls_cd()));
      holder.bigClassTextview.setText(classCode.getLcls_nm());
      holder.smallClassTextview.setText(classCode.getMcls_nm());
      holder.descriptionTextview.setText(classCode.getRemark());
      holder.onRecyclerItemClickListener = this;
      holder.containerView.setBackgroundColor(getBackgroundColor(context, item.isSelected()));
    }
  }

  private int getBackgroundColor(Context context, boolean isSelected) {
    if (isSelected) {
      return ContextCompat.getColor(context, R.color.colorIndigo_200);
    } else {
      return ContextCompat.getColor(context, android.R.color.transparent);
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

  @Override public void add(DetailWork item) {
    items.add(item);
  }

  @DebugLog @Override public void addAll(List<DetailWork> items) {
    this.items.addAll(items);
    for (int i = 0; i < items.size(); i++) {
      DetailWork item = items.get(i);
      boolean isSelected = item.getMcls_cd().equals(nowDetailWork.getMcls_cd());
      if (isSelected) {
        prePosition = i;
      }
      selectableItems.add(new DetailSelectableItem(item, isSelected));
    }
  }

  @Override public DetailWork remove(int position) {
    return items.remove(position);
  }

  @Override public DetailWork getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, DetailWork item) {
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

  @Override public void onItemClick(DetailSelectableItem item) {
    selectableItems.get(prePosition).setSelected(false);
    refresh(prePosition);
    prePosition = selectableItems.indexOf(item);
  }

  @Override public DetailWork getSelectedItem() {
    for (DetailSelectableItem selectableItem : selectableItems) {
      if (selectableItem.isSelected()) {
        return selectableItem.getItem();
      }
    }
    return null;
  }
}