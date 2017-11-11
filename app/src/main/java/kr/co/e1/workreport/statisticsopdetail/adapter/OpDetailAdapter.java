package kr.co.e1.workreport.statisticsopdetail.adapter;

import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.statisticsopdetail.model.OpDetail;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailAdapter extends BaseRecyclerAdapter
    implements BaseAdapterView, BaseAdapterDataModel<OpDetail> {

  private List<OpDetail> items = new ArrayList<>();

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new OpDetailViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_statistics_op_detail_item_default;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof OpDetailViewHolder) {
      OpDetailViewHolder holder = (OpDetailViewHolder) viewHolder;
      OpDetail o = items.get(position);
      holder.nameTextview.setText(o.getName());
      holder.janTextview.setText(o.getJan());
      holder.febTextview.setText(o.getFeb());
      holder.marTextview.setText(o.getMar());
      holder.aprTextview.setText(o.getApr());
      holder.mayTextview.setText(o.getMay());
      holder.junTextview.setText(o.getJun());
      holder.julTextview.setText(o.getJul());
      holder.augTextview.setText(o.getAug());
      holder.sepTextview.setText(o.getSep());
      holder.octTextview.setText(o.getOct());
      holder.novTextview.setText(o.getNov());
      holder.decTextview.setText(o.getDec());
      holder.nowOpRatioTextview.setText(o.getNowOpRatio());
      holder.yearOpRatioTextview.setText(o.getYearOpRatio());
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @DebugLog @Override public void refresh() {
    //notifyDataSetChanged();
  }

  @DebugLog @Override public void add(OpDetail item) {
    this.items.add(item);
  }

  @DebugLog @Override public void addAll(List<OpDetail> items) {
    this.items.addAll(items);
  }

  @Override public OpDetail remove(int position) {
    return items.remove(position);
  }

  @Override public OpDetail getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, OpDetail item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }
}
