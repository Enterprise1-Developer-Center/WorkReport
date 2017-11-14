package kr.co.e1.workreport.teamreportdialog.adapter;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.adapter.ReportAdapterView;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class TeamReportAdapter extends BaseRecyclerAdapter
    implements ReportAdapterView, BaseAdapterDataModel<ReportEntry> {

  private OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener;

  public TeamReportAdapter(OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener) {
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
    return new TeamReportViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_main_report_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof TeamReportViewHolder) {
      TeamReportViewHolder holder = (TeamReportViewHolder) viewHolder;
      ReportEntry entry = items.get(position);
      holder.iconImageView.setImageResource(entry.getType().getResId());
      holder.contentsTextView.setText(entry.getContents());
      if (entry.getType() == ReportType.DATE) {
        holder.itemView.setOnClickListener(view -> onRecyclerItemClickListener.onItemClick(entry));
        holder.itemView.setBackgroundResource(getBackgroundRes(holder.iconImageView.getContext()));
      }
    }
  }

  private @DrawableRes int getBackgroundRes(Context context) {
    TypedValue outValue = new TypedValue();
    context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
    return outValue.resourceId;
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
