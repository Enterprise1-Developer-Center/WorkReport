package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.fd_class;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 10. 25
 */

public class ClassDialogViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.code_textview) TextView codeTextview;
  @BindView(R.id.large_class_textview) TextView lclsTextview;
  @BindView(R.id.small_class_textview) TextView mclsTextview;
  @BindView(R.id.desc_textview) TextView descTextview;

  public ClassDialogViewHolder(View itemView) {
    super(itemView);
  }
}