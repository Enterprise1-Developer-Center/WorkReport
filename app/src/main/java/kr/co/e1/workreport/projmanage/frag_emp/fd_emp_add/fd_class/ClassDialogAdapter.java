package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.fd_class;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import lombok.Setter;

/**
 * Created by jaeho on 2018. 1. 22
 */

public class ClassDialogAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<DetailWork>, BaseAdapterView {

  private List<DetailWork> items = new ArrayList<>();
  @Setter private OnRecyclerItemClickListener<DetailWork> onRecyclerItemClickListener;
  @Setter private int checkedItem = 0;

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new ClassDialogViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.dialog_classification_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof ClassDialogViewHolder) {
      ClassDialogViewHolder holder = (ClassDialogViewHolder) viewHolder;
      DetailWork item = getItem(position);
      holder.codeTextview.setText(item.getMcls_cd());
      holder.lclsTextview.setText(item.getLcls_nm());
      holder.mclsTextview.setText(item.getMcls_nm());
      holder.descTextview.setText(item.getRemark());
      holder.itemView.setOnClickListener(view -> {
        if (onRecyclerItemClickListener != null) {
          onRecyclerItemClickListener.onItemClick(getItem(position));
        }
      });
      if (position == checkedItem) {
        holder.itemView.setBackgroundColor(getBackgroundColor(holder.itemView.getContext(), true));
      } else {
        holder.itemView.setBackgroundColor(getBackgroundColor(holder.itemView.getContext(), false));
      }
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

  @Override public void add(DetailWork item) {
    items.add(item);
  }

  @Override public void addAll(List<DetailWork> items) {
    this.items.addAll(items);
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
  }

  @Override public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }
}