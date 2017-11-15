package kr.co.e1.workreport.main.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class MainReportViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.imageview) ImageView iconImageView;
  @BindView(R.id.textview) TextView contentsTextView;

  public MainReportViewHolder(View itemView) {
    super(itemView);
  }

  void defaultSetting(ReportEntry entry, OnRecyclerItemClickListener<ReportEntry> listener) {
    switch (entry.getType()) {
      case DATE:
      case START_TIME:
      case END_TIME:
      case DETAIL_WORK:
      case PROJECT:
        itemView.setOnClickListener(view -> listener.onItemClick(entry));
        itemView.setBackgroundResource(getBackgroundRes(itemView.getContext()));
        break;
      case DEPT:
      case NAME:
      case WORKING_TIME:
      case MODIFIED_TIME:
        iconImageView.setImageTintList(ColorStateList.valueOf(
            ContextCompat.getColor(itemView.getContext(), android.R.color.darker_gray)));
        break;
    }

    switch (entry.getType()) {
      case DETAIL_WORK:
        contentsTextView.setText(entry.getCode() + " / " + entry.getContents());
        break;
      case PROJECT:
        break;
    }
  }

  private @DrawableRes int getBackgroundRes(Context context) {
    TypedValue outValue = new TypedValue();
    context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
    return outValue.resourceId;
  }
}
