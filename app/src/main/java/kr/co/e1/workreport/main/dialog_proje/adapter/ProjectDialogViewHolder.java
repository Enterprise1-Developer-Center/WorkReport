package kr.co.e1.workreport.main.dialog_proje.adapter;

import android.support.v4.content.ContextCompat;
import android.view.View;
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
  @BindView(R.id.textview) TextView textview;
  @BindView(R.id.recyclerview_item_container) View containerView;
  @Setter private ProjectSelectableItem selectableItem;
  @Setter private OnRecyclerItemClickListener<ProjectSelectableItem> onRecyclerItemClickListener;

  public ProjectDialogViewHolder(View itemView) {
    super(itemView);
  }

  @DebugLog @OnClick(R.id.recyclerview_item_container) void onClick(View view) {
    if (!selectableItem.isSelected()) {
      selectableItem.setSelected(true);
      view.setBackgroundColor(
          ContextCompat.getColor(itemView.getContext(), R.color.colorIndigo_200));
      onRecyclerItemClickListener.onItemClick(selectableItem);
    }
  }
}