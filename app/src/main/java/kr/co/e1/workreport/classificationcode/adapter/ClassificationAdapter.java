package kr.co.e1.workreport.classificationcode.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationcode.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.adapter.BaseRecyclerAdapter;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationAdapter extends BaseRecyclerAdapter
    implements BaseAdapterDataModel<ClassificationCode>, BaseAdapterView {

  private static volatile ClassificationAdapter singletonInstance = null;

  public static ClassificationAdapter getInstance() {
    if (singletonInstance == null) {
      synchronized (Singleton.class) {
        if (singletonInstance == null) {
          singletonInstance = new ClassificationAdapter();
        }
      }
    }
    return singletonInstance;
  }

  private ArrayList<ClassificationCode> items = new ArrayList<>();

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new ClassificationViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_classification_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof ClassificationViewHolder) {
      ClassificationViewHolder holder = (ClassificationViewHolder) viewHolder;
      ClassificationCode classCode = items.get(position);
      holder.codeTextview.setText(classCode.getCode());
      holder.bigClassTextview.setText(classCode.getBigClass());
      holder.smallClassTextview.setText(classCode.getSmallClass());
      holder.descriptionTextview.setText(classCode.getDescription());
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }

  @Override public void add(ClassificationCode item) {
    items.add(item);
  }

  @Override public void addAll(List<ClassificationCode> items) {
    items.addAll(items);
  }

  @Override public ClassificationCode remove(int position) {
    return items.remove(position);
  }

  @Override public ClassificationCode getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, ClassificationCode item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }

  final static class ClassificationViewHolder extends BaseViewHolder {
    @BindView(R.id.code_textview) TextView codeTextview;
    @BindView(R.id.big_class_textview) TextView bigClassTextview;
    @BindView(R.id.small_class_textview) TextView smallClassTextview;
    @BindView(R.id.description_textview) TextView descriptionTextview;
    @BindView(R.id.checkbox) CheckBox checkBox;

    public ClassificationViewHolder(View itemView) {
      super(itemView);
    }
  }
}