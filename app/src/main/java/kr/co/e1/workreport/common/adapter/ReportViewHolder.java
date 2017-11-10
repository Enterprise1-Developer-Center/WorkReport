package kr.co.e1.workreport.common.adapter;

import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class ReportViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.imageview) ImageView iconImageView;
  @BindView(R.id.textview) TextView contentsTextView;
  public ReportViewHolder(View itemView) {
    super(itemView);
    TypedValue outValue = new TypedValue();
    itemView.getContext()
        .getTheme()
        .resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
    itemView.setBackgroundResource(outValue.resourceId);
  }
}
