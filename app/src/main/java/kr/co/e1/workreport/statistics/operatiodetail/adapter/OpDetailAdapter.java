package kr.co.e1.workreport.statistics.operatiodetail.adapter;

import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.statistics.operatiodetail.model.DetailOperationRate;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailAdapter extends BaseRecyclerAdapter
    implements OpDetailAdapterView, BaseAdapterDataModel<DetailOperationRate> {
  private final static int VIEW_TYPE_BODY = 0;
  private final static int VIEW_TYPE_FOOTER = 1;
  private List<DetailOperationRate> items = new ArrayList<>();

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new OpDetailViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    if (viewType == VIEW_TYPE_BODY) {
      return R.layout.content_statistics_op_detail_item_footer;
    } else {
      return R.layout.content_statistics_op_detail_item_body;
    }
  }

  @Override public int getItemViewType(int position) {
    if (position == getItemCount() - 1) {
      return VIEW_TYPE_FOOTER;
    } else {
      return VIEW_TYPE_BODY;
    }
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof OpDetailViewHolder) {
      OpDetailViewHolder holder = (OpDetailViewHolder) viewHolder;
      DetailOperationRate o = items.get(position);
      holder.nameTextview.setText(o.getUser_nm());
      holder.janTextview.setText(String.valueOf(o.getM1()));
      holder.febTextview.setText(String.valueOf(o.getM2()));
      holder.marTextview.setText(String.valueOf(o.getM3()));
      holder.aprTextview.setText(String.valueOf(o.getM4()));
      holder.mayTextview.setText(String.valueOf(o.getM5()));
      holder.junTextview.setText(String.valueOf(o.getM6()));
      holder.julTextview.setText(String.valueOf(o.getM7()));
      holder.augTextview.setText(String.valueOf(o.getM8()));
      holder.sepTextview.setText(String.valueOf(o.getM9()));
      holder.octTextview.setText(String.valueOf(o.getM10()));
      holder.novTextview.setText(String.valueOf(o.getM11()));
      holder.decTextview.setText(String.valueOf(o.getM12()));
      holder.nowOpRatioTextview.setText(String.valueOf(o.getNowsum()));
      holder.yearOpRatioTextview.setText(String.valueOf(o.getTotsum()));
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @DebugLog @Override public void add(DetailOperationRate item) {
    this.items.add(item);
  }

  @DebugLog @Override public void addAll(List<DetailOperationRate> items) {
    this.items.addAll(items);
  }

  @Override public DetailOperationRate remove(int position) {
    return items.remove(position);
  }

  @Override public DetailOperationRate getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, DetailOperationRate item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }

  @Override public void refresh(int position) {
    notifyItemChanged(position);
  }

  @DebugLog public void refresh() {
    notifyItemRangeChanged(0, getSize());
  }
}
