package kr.co.e1.workreport.project.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ProjectDialogAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<Project>, BaseAdapterView,
    OnRecyclerItemClickListener<Project> {

  private ArrayList<Project> items = new ArrayList<>();

  private OnRecyclerItemClickListener<Project> onRecyclerItemClickListener;

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
      holder.checkedTextView.setText(items.get(position).getName());
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }

  @Override public void add(Project item) {
    items.add(item);
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

  @Override public void clear() {
    items.clear();
  }

  @Override public void onItemClick(Project item) {
    onRecyclerItemClickListener.onItemClick(item);
  }
}