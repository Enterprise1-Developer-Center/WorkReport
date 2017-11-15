package kr.co.e1.workreport.project.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.vo.Project;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ProjectDialogAdapter extends BaseRecyclerAdapter
    implements ProjectAdapterDataModel, BaseAdapterView,
    OnRecyclerItemClickListener<ProjectSelectableItem> {

  private ArrayList<Project> items = new ArrayList<>();
  private ArrayList<ProjectSelectableItem> selectableItems = new ArrayList<>();

  @Accessors(chain = true) @Setter private String selectedCode = "0";

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new ProjectDialogViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.dialog_project_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof ProjectDialogViewHolder) {
      ProjectDialogViewHolder holder = (ProjectDialogViewHolder) viewHolder;
      ProjectSelectableItem selectableItem = selectableItems.get(position);
      Project project = selectableItem.getItem();
      holder.textview.setText(project.getName());
      holder.setOnRecyclerItemClickListener(this);
      holder.setSelectableItem(selectableItem);
      holder.itemView.setBackgroundColor(
          getBackgroundColor(holder.itemView.getContext(), selectableItem.isSelected()));
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
    notifyDataSetChanged();
  }

  @Override public void add(Project item) {
    items.add(item);
    selectableItems.add(new ProjectSelectableItem(item, false));
  }

  @Override public void addAll(List<Project> items) {
    this.items.addAll(items);
    for (int i = 0; i < this.items.size(); i++) {
      for (Project item : this.items) {
        boolean isSelected = false;
        if (item.getCode().equals(selectedCode)) {
          isSelected = true;
          prePosition = i;
        }
        selectableItems.add(new ProjectSelectableItem(item, isSelected));
      }
    }
  }

  @Override public Project remove(int position) {
    return items.remove(position);
  }

  @Override public Project getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, Project item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  public void refresh(int oldPosition) {
    notifyItemChanged(oldPosition);
  }

  @Override public void clear() {
    items.clear();
    selectableItems.clear();
  }

  private int prePosition;

  @Override public void onItemClick(ProjectSelectableItem item) {
    selectableItems.get(prePosition).setSelected(false);
    refresh(prePosition);
    prePosition = selectableItems.indexOf(item);
  }

  @Override public ProjectSelectableItem getSelectableItem() {
    for (ProjectSelectableItem selectableItem : selectableItems) {
      if (selectableItem.isSelected()) {
        return selectableItem;
      }
    }
    return null;
  }
}