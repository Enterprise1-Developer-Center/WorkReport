package kr.co.e1.workreport.projmanage.frag_proj.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class ProjListAdapter extends BaseRecyclerAdapter
    implements ProjListAdapterView, BaseAdapterDataModel<Project> {
  private List<Project> items = new ArrayList<>();
  @Setter @Accessors(chain = true) private OnRecyclerItemClickListener<Project>
      onRecyclerItemClickListener;

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new ProjListViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.fragment_proj_manage_proj_list_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof ProjListViewHolder) {
      ProjListViewHolder holder = (ProjListViewHolder) viewHolder;
      Project proj = items.get(position);
      holder.projCdTextview.setText(proj.getProj_cd());
      holder.projNmTextview.setText(proj.getProj_nm());
      holder.itemView.setOnClickListener(view -> {
        if (onRecyclerItemClickListener != null) {
          onRecyclerItemClickListener.onItemClick(proj);
        }
      });
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }

  @Override public void add(Project item) {
    items.add(item);
  }

  @Override public void addAll(List<Project> items) {
    this.items.addAll(items);
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

  @Override public void refreshRemove() {
    notifyItemRangeRemoved(0, getSize());
  }
}
