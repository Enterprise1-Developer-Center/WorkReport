package kr.co.e1.workreport.teamreport.dialog.adapter;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.LayoutUtility;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class TeamReportDialogAdapter extends BaseRecyclerAdapter
    implements TeamDialogAdapterView, TeamDialogAdapterDataModel<ReportEntry> {

  private OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener;

  public TeamReportDialogAdapter(
      OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener) {
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
    return new TeamDialogViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.fragment_report_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof TeamDialogViewHolder) {
      TeamDialogViewHolder holder = (TeamDialogViewHolder) viewHolder;
      Context context = holder.itemView.getContext();
      ReportEntry entry = items.get(position);
      holder.imageView.setImageResource(entry.getType().getResId());
      holder.contentsTextView.setText(entry.getContents());
      if (entry.getType() == ReportType.DATE) {
        holder.itemView.setOnClickListener(view -> onRecyclerItemClickListener.onItemClick(entry));
        holder.itemView.setBackgroundResource(LayoutUtility.getSelectableItemBackground(context));
        holder.imageView.setImageTintList(
            LayoutUtility.getColorStateList(context, android.R.color.black));
      } else {
        holder.itemView.setOnClickListener(null);
        holder.itemView.setBackgroundResource(0);
        holder.imageView.setImageTintList(
            LayoutUtility.getColorStateList(context, android.R.color.darker_gray));
      }
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }

  @Override public void refreshRemove() {
    notifyItemRangeRemoved(0, getSize());
  }

  @Override public void edit(ReportType type, String content) {
    this.items.get(type.getPosition()).setContents(content);
  }
}
