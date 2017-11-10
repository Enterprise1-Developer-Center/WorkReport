package kr.co.e1.workreport.main.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.adapter.ReportAdapterView;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class MainReportAdapter extends BaseRecyclerAdapter
    implements ReportAdapterView, BaseAdapterDataModel<ReportEntry> {

  private OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener;

  public MainReportAdapter(OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener) {
    this.onRecyclerItemClickListener = onRecyclerItemClickListener;
  }

  private List<ReportEntry> items = new ArrayList<>();

  @Override public void add(ReportEntry item) {
    items.add(item);
  }

  @Override public void addAll(List<ReportEntry> items) {
    this.items.addAll(items);
  }

  @Override public ReportEntry remove(int position) {
    return items.remove(position);
  }

  @Override public ReportEntry getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, ReportEntry item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new MainReportViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_main_report_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof MainReportViewHolder) {
      MainReportViewHolder holder = (MainReportViewHolder) viewHolder;
      ReportEntry entry = items.get(position);
      holder.iconImageView.setImageResource(entry.getEntry().getResId());
      holder.contentsTextView.setText(entry.getContents());
      holder.itemView.setOnClickListener(view -> onRecyclerItemClickListener.onItemClick(entry));
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh(int position) {
    notifyItemChanged(position);
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }
}
