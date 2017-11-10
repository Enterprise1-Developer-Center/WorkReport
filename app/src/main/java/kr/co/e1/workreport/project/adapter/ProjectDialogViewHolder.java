package kr.co.e1.workreport.project.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 10. 25
 */

public class ProjectDialogViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @Setter private OnRecyclerItemClickListener<ProjectSelectableItem> onRecyclerItemClickListener;
  @BindView(R.id.checkbox) CheckBox checkbox;
  @BindView(R.id.textview) TextView textview;
  @Setter private ProjectSelectableItem selectableItem;

  public ProjectDialogViewHolder(View itemView) {
    super(itemView);
  }

  @DebugLog @OnClick(R.id.recyclerview_item_container) void onClick() {
    checkbox.setChecked(true);
    if (checkbox.isChecked()) onRecyclerItemClickListener.onItemClick(selectableItem);
  }
}