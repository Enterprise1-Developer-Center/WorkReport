package kr.co.e1.workreport.main.adapter;

import android.view.View;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class MainAdapter extends BaseRecyclerAdapter
    implements BaseAdapterView, BaseAdapterDataModel<ReportEntry> {
  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return null;
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_main_report_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  @Override public void refresh() {

  }

  @Override public void add(ReportEntry item) {

  }

  @Override public void addAll(List<ReportEntry> items) {

  }

  @Override public ReportEntry remove(int position) {
    return null;
  }

  @Override public ReportEntry getItem(int position) {
    return null;
  }

  @Override public void add(int index, ReportEntry item) {

  }

  @Override public int getSize() {
    return 0;
  }

  @Override public void clear() {

  }
}
