package kr.co.e1.workreport.statisticstotal.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class TotalViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.name_textview) TextView nameTextView;
  @BindView(R.id.value_textview) TextView valueTextView;

  public TotalViewHolder(View itemView) {
    super(itemView);
  }
}
