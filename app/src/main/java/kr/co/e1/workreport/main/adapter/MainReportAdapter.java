package kr.co.e1.workreport.main.adapter;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.utils.LayoutUtility;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.main.model.SummaryReportContent;
import kr.co.e1.workreport.main.dg_proje.model.Project;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class MainReportAdapter extends BaseRecyclerAdapter
    implements MainAdapterView, MainAdapterDataModel<ReportEntry> {
  private final static int ITEM_DEFAULT = 0;
  private final static int ITEM_SAVE = 1;
  private OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener;
  private OnSaveButtonClickListener<SummaryReportContent> onSaveButtonClickListener;

  public MainReportAdapter(OnRecyclerItemClickListener<ReportEntry> onRecyclerItemClickListener,
      OnSaveButtonClickListener<SummaryReportContent> onSaveButtonClickListener) {
    this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    this.onSaveButtonClickListener = onSaveButtonClickListener;
  }

  private List<ReportEntry> items = new ArrayList<>();

  @Override public void add(ReportEntry item) {
    items.add(item);
    items.add(new ReportEntry().setType(null).setContents(null));
  }

  @Override public void addAll(List<ReportEntry> items) {
    this.items.addAll(items);
    this.items.add(new ReportEntry().setType(null).setContents(null));
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
    if (viewType == ITEM_DEFAULT) {
      return new MainReportViewHolder(view);
    } else {
      return new MainSaveViewHolder(view);
    }
  }

  @Override public int getItemViewType(int position) {
    if (position < items.size() - 1) {
      return ITEM_DEFAULT;
    } else {
      return ITEM_SAVE;
    }
  }

  @Override public int getLayoutRes(int viewType) {
    if (viewType == ITEM_DEFAULT) {
      return R.layout.content_main_report_item;
    } else {
      return R.layout.content_main_save_item;
    }
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof MainReportViewHolder) {
      MainReportViewHolder holder = (MainReportViewHolder) viewHolder;
      Context context = holder.itemView.getContext();
      ReportEntry entry = items.get(position);
      holder.imageView.setImageResource(entry.getType().getResId());
      if (entry.getType() == ReportType.DETAIL_WORK) {
        holder.textView.setText(entry.getMcls_cd() + " / " + entry.getContents());
      } else if (entry.getType() == ReportType.DATE) {
        String date = DateUtils.getIncludeDayOfWeek(entry.getContents());
        //String date = (entry.getContents());
        holder.textView.setText(date);
      } else {
        holder.textView.setText(entry.getContents());
      }

      ReportType type = entry.getType();
      if (type == ReportType.DATE
          || type == ReportType.START_TIME
          || type == ReportType.END_TIME
          || type == ReportType.DETAIL_WORK
          || type == ReportType.PROJECT) {
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
    } else {
      MainSaveViewHolder holder = (MainSaveViewHolder) viewHolder;
      holder.saveButton.setOnClickListener(view -> {
        SummaryReportContent sContent = new SummaryReportContent(items);
        onSaveButtonClickListener.onSaveClick(sContent);
      });
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh(int position) {
    notifyItemChanged(position);
  }

  @Override public void refreshRemove() {
    notifyItemRangeRemoved(0, getSize());
  }

  @Override public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }

  @Override public void edit(ReportType type, String contents) {
    items.get(type.getPosition()).setContents(contents);
  }

  @Override public void edit(ReportType type, Project o) {
    items.get(type.getPosition()).setContents(o.getProj_nm()).setProj_cd(o.getProj_cd());
  }

  @Override public void edit(ReportType type, DetailWork o) {
    items.get(type.getPosition())
        .setContents(o.getDetail())
        .setLcls_cd(o.getLcls_cd())
        .setMcls_cd(o.getMcls_cd());
  }
}
