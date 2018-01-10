package kr.co.e1.workreport.statistics.ac_detail.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 11. 9
 */

public class OpDetailViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.name_textview) TextView nameTextview;
  @BindView(R.id.jan_textview) TextView janTextview;
  @BindView(R.id.feb_textview) TextView febTextview;
  @BindView(R.id.mar_textview) TextView marTextview;
  @BindView(R.id.apr_textview) TextView aprTextview;
  @BindView(R.id.may_textview) TextView mayTextview;
  @BindView(R.id.jun_textview) TextView junTextview;
  @BindView(R.id.jul_textview) TextView julTextview;
  @BindView(R.id.aug_textview) TextView augTextview;
  @BindView(R.id.sep_textview) TextView sepTextview;
  @BindView(R.id.oct_textview) TextView octTextview;
  @BindView(R.id.nov_textview) TextView novTextview;
  @BindView(R.id.dec_textview) TextView decTextview;
  @BindView(R.id.now_op_ratio_textview) TextView nowOpRatioTextview;
  @BindView(R.id.year_op_ratio_textview) TextView yearOpRatioTextview;

  public OpDetailViewHolder(View itemView) {
    super(itemView);
  }
}
