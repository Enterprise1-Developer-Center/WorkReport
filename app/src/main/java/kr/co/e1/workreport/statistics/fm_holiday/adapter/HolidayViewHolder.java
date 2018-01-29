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
  @BindView(R.id.holiday_textview) TextView holidayTextView;
  @BindView(R.id.holiday_name_textview) TextView holidayNameTextView;

  public HolidayViewHolder(View itemView) {
    super(itemView);
  }
}
