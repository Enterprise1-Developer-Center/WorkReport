package kr.co.e1.workreport.teamreport.dialog.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class TeamDialogViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.imageview) ImageView imageView;
  @BindView(R.id.textview) TextView contentsTextView;

  public TeamDialogViewHolder(View itemView) {
    super(itemView);
  }
}