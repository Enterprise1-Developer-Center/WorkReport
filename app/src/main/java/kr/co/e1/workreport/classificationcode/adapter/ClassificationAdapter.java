package kr.co.e1.workreport.classificationcode.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
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

  private ArrayList<ClassificationCode> items = new ArrayList<>();
  private ArrayList<SelectableItem> selectableItems = new ArrayList<>();

  private ClassificationAdapter() {
  }

  public static ClassificationAdapter getInstance() {
    if (singletonInstance == null) {
      synchronized (ClassificationAdapter.class) {
        if (singletonInstance == null) {
          singletonInstance = new ClassificationAdapter();
        }
      }
    }
    return singletonInstance;
  }

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return new ClassificationViewHolder(view);
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.content_classification_recycler_item;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof ClassificationViewHolder) {
      ClassificationViewHolder holder = (ClassificationViewHolder) viewHolder;
      SelectableItem item = selectableItems.get(position);
      ClassificationCode classCode = item.getClassificationCode();
      holder.selectableItem = selectableItems.get(position);
      holder.codeTextview.setText(classCode.getCode());
      holder.bigClassTextview.setText(classCode.getBigClass());
      holder.smallClassTextview.setText(classCode.getSmallClass());
      holder.descriptionTextview.setText(classCode.getDescription());
      holder.checkBox.setChecked(item.isSelected());
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
    selectableItems.add(new SelectableItem(item, false));
    /*
    if (item.getCode() != null) {
      if (item.getCode().length() > 0) {
        selectableItems.add(new SelectableItem(item, true));
      } else {
        selectableItems.add(new SelectableItem(item, false));
      }
    }
    */
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
}