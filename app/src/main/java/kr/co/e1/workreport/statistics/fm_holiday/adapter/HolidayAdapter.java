package kr.co.e1.workreport.statistics.fm_holiday.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class HolidayAdapter extends BaseRecyclerAdapter
    implements HolidayAdapterView, BaseAdapterDataModel<Holiday> {
  private List<Holiday> items = new ArrayList<>();
  @Setter @Accessors(chain = true) private OnRecyclerItemClickListener<Holiday>
      onRecyclerItemClickListener;

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new HolidayViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.fragment_holiday_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof HolidayViewHolder) {
      HolidayViewHolder holder = (HolidayViewHolder) viewHolder;
      Holiday holiday = items.get(position);
      holder.holidayTextView.setText(
          DateUtils.convertStringToFormatString(holiday.getYmd(), "yyyyMMdd", "yyyy-MM-dd (EEEE)",
              Locale.KOREA));
      holder.holidayNameTextView.setText(
          holiday.getName().indexOf("요일") == -1 ? holiday.getName() : "");
      holder.itemView.setOnClickListener(view -> {
        if (onRecyclerItemClickListener != null) {
          onRecyclerItemClickListener.onItemClick(holiday);
        }
      });
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }

  @Override public void add(Holiday item) {
    items.add(item);
  }

  @Override public void addAll(List<Holiday> items) {
    this.items.addAll(items);
  }

  @Override public Holiday remove(int position) {
    return items.remove(position);
  }

  @Override public Holiday getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, Holiday item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }

  @Override public void refreshRemove() {
    notifyItemRangeRemoved(0, getSize());
  }
}
