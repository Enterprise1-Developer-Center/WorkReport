package kr.co.e1.workreport.statisticstotal.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class TotalAdapter extends BaseRecyclerAdapter
    implements BaseAdapterView, BaseAdapterDataModel<TotalSummary> {
  private List<TotalSummary> items = new ArrayList<>();

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new TotalViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.fragment_total_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof TotalViewHolder) {
      TotalViewHolder holder = (TotalViewHolder) viewHolder;
      TotalSummary summary = items.get(position);
      holder.nameTextView.setText(summary.getName());
      holder.valueTextView.setText(String.valueOf(summary.getValue()));
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }

  @Override public void add(TotalSummary item) {
    items.add(item);
  }

  @Override public void addAll(List<TotalSummary> items) {
    this.items.addAll(items);
  }

  @Override public TotalSummary remove(int position) {
    return items.remove(position);
  }

  @Override public TotalSummary getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, TotalSummary item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }
}
