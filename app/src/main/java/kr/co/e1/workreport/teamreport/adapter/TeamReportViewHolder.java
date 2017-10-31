package kr.co.e1.workreport.teamreport.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import kr.co.e1.workreport.teamreport.vo.TeamReport;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TeamReportViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.recyclerview_item_container) View itemContainer;
  @BindView(R.id.name_textview) TextView nameTextView;
  @BindView(R.id.summary_textview) TextView summaryTextView;
  @Setter private OnRecyclerItemClickListener<TeamReport> onRecyclerItemClickListener;
  @Setter private TeamReport teamReport;

  public TeamReportViewHolder(View itemView) {
    super(itemView);
    itemView.setOnClickListener(view -> {
      onRecyclerItemClickListener.onItemClick(this.teamReport);
    });
  }
}
