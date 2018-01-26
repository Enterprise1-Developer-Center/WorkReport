package kr.co.e1.workreport.statistics.fm_holiday.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class HolidayViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.proj_code_textview) TextView projCdTextview;
  @BindView(R.id.proj_name_textview) TextView projNmTextview;

  public HolidayViewHolder(View itemView) {
    super(itemView);
  }
}
