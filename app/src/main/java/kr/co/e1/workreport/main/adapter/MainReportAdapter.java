package kr.co.e1.workreport.main.adapter;

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
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class MainReportAdapter extends BaseRecyclerAdapter
    implements ReportAdapterView, MainAdapterDataModel<ReportEntry> {

  private OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener;
  private OnSaveButtonClickListener<List<ReportEntry>> onSaveButtonClickListener;

  public MainReportAdapter(OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener,
      OnSaveButtonClickListener<List<ReportEntry>> onSaveButtonClickListener) {
    this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    this.onSaveButtonClickListener = onSaveButtonClickListener;
  }

  private List<ReportEntry> items = new ArrayList<>();

  @Override public void add(ReportEntry item) {
    items.add(item);
    items.add(new ReportEntry(null, null));
  }

  @Override public void addAll(List<ReportEntry> items) {
    this.items.addAll(items);
    this.items.add(new ReportEntry(null, null));
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
    if (viewType == 0) {
      return new MainReportViewHolder(view);
    } else {
      return new MainSaveViewHolder(view);
    }
  }

  @Override public int getItemViewType(int position) {
    if (position < items.size() - 1) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override public int getLayoutRes(int viewType) {
    if (viewType == 0) {
      return R.layout.content_main_report_item;
    } else {
      return R.layout.content_main_save_item;
    }
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof MainReportViewHolder) {
      MainReportViewHolder holder = (MainReportViewHolder) viewHolder;
      ReportEntry entry = items.get(position);
      holder.iconImageView.setImageResource(entry.getEntry().getResId());
      holder.contentsTextView.setText(entry.getContents());
      switch (entry.getEntry()) {
        case DATE:
        case START_TIME:
        case END_TIME:
        case DETAIL_WORK:
        case PROJECT:
          holder.itemView.setOnClickListener(
              view -> onRecyclerItemClickListener.onItemClick(entry));
          holder.itemView.setBackgroundResource(
              getBackgroundRes(holder.iconImageView.getContext()));
          break;
      }
    } else {
      MainSaveViewHolder holder = (MainSaveViewHolder) viewHolder;
      holder.saveButton.setOnClickListener(view -> {
        onSaveButtonClickListener.onSaveClick(items);
      });
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

  @Override public void edit(ReportType type, String contents) {
    items.get(type.getPosition()).setContents(contents);
  }
}
