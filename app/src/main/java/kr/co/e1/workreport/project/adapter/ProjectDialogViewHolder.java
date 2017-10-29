package kr.co.e1.workreport.project.adapter;

import android.view.View;
import android.widget.CheckedTextView;
import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.vo.Project;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 10. 25
 */

public class ProjectDialogViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @Setter private OnRecyclerItemClickListener<Project> onRecyclerItemClickListener;
  @BindView(R.id.checked_textview) CheckedTextView checkedTextView;

  public ProjectDialogViewHolder(View itemView) {
    super(itemView);
  }

  @DebugLog @OnClick(R.id.checked_textview) void onClick(View view) {

  }
}