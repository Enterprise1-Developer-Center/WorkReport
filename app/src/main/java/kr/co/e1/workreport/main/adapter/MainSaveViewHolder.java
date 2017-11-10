package kr.co.e1.workreport.main.adapter;

import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 11. 10
 */

public class MainSaveViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.save_button) Button saveButton;
  public MainSaveViewHolder(View itemView) {
    super(itemView);
  }
}
