package kr.co.e1.workreport.projmanage.frag_emp.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class EmpListAdapter extends BaseRecyclerAdapter
    implements EmpListAdapterView, BaseAdapterDataModel<Employee> {
  private List<Employee> items = new ArrayList<>();
  @Setter @Accessors(chain = true) private OnRecyclerItemClickListener<Employee>
      onRecyclerItemClickListener;

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new EmpListViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.fragment_proj_manage_emp_list_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof EmpListViewHolder) {
      EmpListViewHolder holder = (EmpListViewHolder) viewHolder;
      Employee item = items.get(position);
      holder.startDateTextview.setText(
          DateUtils.convertStringToFormatString(item.getUser_sdate(), "yyyyMMdd",
              "yyyy-MM-dd (EEE)", Locale.KOREA));
      holder.endDateTextview.setText(
          DateUtils.convertStringToFormatString(item.getUser_edate(), "yyyyMMdd",
              "yyyy-MM-dd (EEE)", Locale.KOREA));
      holder.userNameTextview.setText(item.getUser_nm());
      holder.projNameTextview.setText(item.getProj_nm());
      holder.itemView.setOnClickListener(view -> {
        if (onRecyclerItemClickListener != null) {
          onRecyclerItemClickListener.onItemClick(item);
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

  @Override public void add(Employee item) {
    items.add(item);
  }

  @Override public void addAll(List<Employee> items) {
    this.items.addAll(items);
  }

  @Override public Employee remove(int position) {
    return items.remove(position);
  }

  @Override public Employee getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, Employee item) {
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
