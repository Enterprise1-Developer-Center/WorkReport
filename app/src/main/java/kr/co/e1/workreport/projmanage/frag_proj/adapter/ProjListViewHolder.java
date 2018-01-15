package kr.co.e1.workreport.projmanage.frag_proj.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class ProjListViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.proj_cd_textview) TextView projCdTextview;
  @BindView(R.id.proj_nm_textview) TextView projNmTextview;

  public ProjListViewHolder(View itemView) {
    super(itemView);
  }
}
