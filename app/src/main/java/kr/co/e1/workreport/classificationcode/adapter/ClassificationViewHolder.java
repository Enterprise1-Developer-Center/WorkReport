package kr.co.e1.workreport.classificationcode.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 10. 25
 */

public class ClassificationViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
  @BindView(R.id.code_textview) TextView codeTextview;
  @BindView(R.id.big_class_textview) TextView bigClassTextview;
  @BindView(R.id.small_class_textview) TextView smallClassTextview;
  @BindView(R.id.description_textview) TextView descriptionTextview;
  @BindView(R.id.checkbox) CheckBox checkBox;
  SelectableItem selectableItem;
  public ClassificationViewHolder(View itemView) {
    super(itemView);
  }
}
