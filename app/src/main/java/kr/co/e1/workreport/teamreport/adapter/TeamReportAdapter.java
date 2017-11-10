package kr.co.e1.workreport.teamreport.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreport.vo.TeamReport;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<TeamReport>, BaseAdapterView {
  private ArrayList<TeamReport> items = new ArrayList<>();

  private OnRecyclerItemClickListener<TeamReport> onRecyclerItemClickListener;

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
      TeamReport t = items.get(position);
      holder.setTeamReport(t);
      holder.nameTextView.setText(t.getName());
      holder.summaryTextView.setText(t.getSummary());
      holder.setOnRecyclerItemClickListener(onRecyclerItemClickListener);
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }

  public void refresh(int position) {
    notifyItemChanged(position);
  }

  @Override public void add(TeamReport item) {
    items.add(item);
  }

  @Override public void addAll(List<TeamReport> items) {
    items.addAll(items);
  }

  @Override public TeamReport remove(int position) {
    return items.remove(position);
  }

  @Override public TeamReport getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, TeamReport item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }
}
