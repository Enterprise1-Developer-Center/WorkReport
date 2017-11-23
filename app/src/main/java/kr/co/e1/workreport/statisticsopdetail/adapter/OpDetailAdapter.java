package kr.co.e1.workreport.statisticsopdetail.adapter;

import android.view.View;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.ObjectUtils;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.statisticsop.model.OpRatioHeader;
import kr.co.e1.workreport.statisticsop.model.OpRatioItem;
import kr.co.e1.workreport.statisticsop.model.OpRatioTotal;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailAdapter extends BaseRecyclerAdapter
    implements OpDetailAdapterView, OpDetailAdapterDataModel<OpRatioItem> {
  private final static int VIEW_TYPE_BODY = 1;
  private final static int VIEW_TYPE_FOOTER = 2;

  private OpRatioHeader header;
  private List<OpRatioItem> items = new ArrayList<>();
  private OpRatioTotal footer;

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    switch (viewType) {
      case VIEW_TYPE_FOOTER:
        return new OpDetailFooterViewHolder(view);
      case VIEW_TYPE_BODY:
        return new OpDetailViewHolder(view);
      default:
        return new OpDetailViewHolder(view);
    }
  }

  @Override public int getLayoutRes(int viewType) {
    switch (viewType) {
      case VIEW_TYPE_FOOTER:
        return R.layout.content_statistics_op_detail_item_footer;
      case VIEW_TYPE_BODY:
        return R.layout.content_statistics_op_detail_item_body;
      default:
        return R.layout.content_statistics_op_detail_item_body;
    }
  }

  @Override public int getItemViewType(int position) {
    if (position == getSize() - 1) {
      return VIEW_TYPE_FOOTER;
    } else {
      return VIEW_TYPE_BODY;
    }
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof OpDetailViewHolder) {
      OpDetailViewHolder holder = (OpDetailViewHolder) viewHolder;
      OpRatioItem o = items.get(position);
      holder.nameTextview.setText(o.getUserNm());
      holder.janTextview.setText(String.valueOf(o.getJan()));
      holder.febTextview.setText(String.valueOf(o.getFeb()));
      holder.marTextview.setText(String.valueOf(o.getMar()));
      holder.aprTextview.setText(String.valueOf(o.getApr()));
      holder.mayTextview.setText(String.valueOf(o.getMay()));
      holder.junTextview.setText(String.valueOf(o.getJun()));
      holder.julTextview.setText(String.valueOf(o.getJul()));
      holder.augTextview.setText(String.valueOf(o.getAug()));
      holder.sepTextview.setText(String.valueOf(o.getSep()));
      holder.octTextview.setText(String.valueOf(o.getOct()));
      holder.novTextview.setText(String.valueOf(o.getNov()));
      holder.decTextview.setText(String.valueOf(o.getDec()));
      holder.nowOpRatioTextview.setText(String.valueOf(o.getCurOpr()));
      holder.yearOpRatioTextview.setText(String.valueOf(o.getYearOpr()));
    } else if (viewHolder instanceof OpDetailFooterViewHolder) {
      OpDetailFooterViewHolder holder = (OpDetailFooterViewHolder) viewHolder;
      holder.nameTextview.setText(footer.getUserNm());
      holder.janTextview.setText(String.valueOf(footer.getJan()));
      holder.febTextview.setText(String.valueOf(footer.getFeb()));
      holder.marTextview.setText(String.valueOf(footer.getMar()));
      holder.aprTextview.setText(String.valueOf(footer.getApr()));
      holder.mayTextview.setText(String.valueOf(footer.getMay()));
      holder.junTextview.setText(String.valueOf(footer.getJun()));
      holder.julTextview.setText(String.valueOf(footer.getJul()));
      holder.augTextview.setText(String.valueOf(footer.getAug()));
      holder.sepTextview.setText(String.valueOf(footer.getSep()));
      holder.octTextview.setText(String.valueOf(footer.getOct()));
      holder.novTextview.setText(String.valueOf(footer.getNov()));
      holder.decTextview.setText(String.valueOf(footer.getDec()));
      holder.nowOpRatioTextview.setText(String.valueOf(footer.getCurOpr()));
      holder.yearOpRatioTextview.setText(String.valueOf(footer.getYearOpr()));
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @DebugLog @Override public void add(OpRatioItem item) {
    this.items.add(item);
  }

  @DebugLog @Override public void addAll(List<OpRatioItem> items) {
    this.items.addAll(items);
  }

  @Override public OpRatioItem remove(int position) {
    return items.remove(position);
  }

  @Override public OpRatioItem getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, OpRatioItem item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    int size = items.size() + (ObjectUtils.isEmpty(footer) ? 0 : 1); //(body size + footer)
    return size;
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

  @Override public void addFooter(OpRatioTotal footer) {
    this.footer = footer;
  }
}
