package kr.co.e1.workreport.classificationdialog.adapter;

import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.SelectableItem;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class ClassificationSelectableItem extends SelectableItem<ClassificationCode> {

  public ClassificationSelectableItem(ClassificationCode classificationCode, boolean isSelected) {
    super(classificationCode, isSelected);
  }
}
