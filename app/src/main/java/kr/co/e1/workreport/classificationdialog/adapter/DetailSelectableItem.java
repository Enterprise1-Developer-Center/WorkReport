package kr.co.e1.workreport.classificationdialog.adapter;

import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.adapter.SelectableItem;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class DetailSelectableItem extends SelectableItem<DetailWork> {
  public DetailSelectableItem(DetailWork classificationCode, boolean isSelected) {
    super(classificationCode, isSelected);
  }
}
