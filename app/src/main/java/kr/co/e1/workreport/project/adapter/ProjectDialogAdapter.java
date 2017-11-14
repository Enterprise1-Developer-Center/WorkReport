package kr.co.e1.workreport.project.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ProjectDialogAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<Project>, BaseAdapterView,
    OnRecyclerItemClickListener<ProjectSelectableItem> {

  private ArrayList<Project> items = new ArrayList<>();
  private ArrayList<ProjectSelectableItem> selectableItems = new ArrayList<>();

  private OnRecyclerItemClickListener<ProjectSelectableItem> onRecyclerItemClickListener;

  @Inject public ProjectDialogAdapter(OnRecyclerItemClickListener listener) {
    this.onRecyclerItemClickListener = listener;
  }

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
      holder.checkbox.setChecked(selectableItem.isSelected());
      holder.checkbox.setEnabled(false);
      holder.setOnRecyclerItemClickListener(this);
      holder.setSelectableItem(selectableItem);
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
    items.addAll(items);
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
    for (ProjectSelectableItem selectableItem : selectableItems) {
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