package kr.co.e1.workreport.projmanage.frag_emp.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class EmpListViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.start_date_textview) TextView startDateTextview;
  @BindView(R.id.end_date_textview) TextView endDateTextview;
  @BindView(R.id.user_name_textview) TextView userNameTextview;
  @BindView(R.id.proj_name_textview) TextView projNameTextview;

  public EmpListViewHolder(View itemView) {
    super(itemView);
  }
}
