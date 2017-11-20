package kr.co.e1.workreport.teamreport.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreport.model.TeamReportContent;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<TeamReportContent>, TeamReportAdapterView {
  private ArrayList<TeamReportContent> items = new ArrayList<>();

  private OnRecyclerItemClickListener<TeamReportContent> onRecyclerItemClickListener;

  public TeamReportAdapter(OnRecyclerItemClickListener listener) {
    onRecyclerItemClickListener = listener;
  }

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new TeamReportViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_team_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof TeamReportViewHolder) {
      TeamReportViewHolder holder = (TeamReportViewHolder) viewHolder;
      TeamReportContent t = items.get(position);
      holder.setTeamReport(t);
      holder.nameTextView.setText(t.getName());
      final String summary = t.getProj_nm() + " / " + t.getDetail();
      holder.summaryTextView.setText(summary);
      holder.setOnRecyclerItemClickListener(onRecyclerItemClickListener);
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }

  @Override public void add(TeamReportContent item) {
    items.add(item);
  }

  @Override public void addAll(List<TeamReportContent> items) {
    this.items.addAll(items);
  }

  @Override public TeamReportContent remove(int position) {
    return items.remove(position);
  }

  @Override public TeamReportContent getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, TeamReportContent item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }
}
