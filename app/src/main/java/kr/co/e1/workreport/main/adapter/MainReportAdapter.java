package kr.co.e1.workreport.main.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.adapter.ReportAdapterView;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.vo.Project;

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
      holder.defaultSetting(entry, onRecyclerItemClickListener);
      holder.iconImageView.setImageResource(entry.getType().getResId());
      if (entry.getType() == ReportType.DETAIL_WORK) {
        holder.contentsTextView.setText(entry.getCode() + " / " + entry.getContents());
      } else {
        holder.contentsTextView.setText(entry.getContents());
      }
    } else {
      MainSaveViewHolder holder = (MainSaveViewHolder) viewHolder;
      holder.saveButton.setOnClickListener(view -> {
        onSaveButtonClickListener.onSaveClick(items);
      });
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh(int position) {
    notifyItemChanged(position);
  }

  @Override public void refresh() {
    for (int i = 0; i < items.size(); i++) {
      notifyItemChanged(i);
    }
  }

  @Override public void edit(ReportType type, String contents) {
    items.get(type.getPosition()).setContents(contents);
  }

  @Override public void edit(ReportType type, Project o) {
    items.get(type.getPosition()).setContents(o.getName()).setCode(o.getCode());
  }

  @Override public void edit(ReportType type, ClassificationCode code, String work) {
    items.get(type.getPosition()).setContents(work).setCode(code.getSmallClassCode());
  }
}
