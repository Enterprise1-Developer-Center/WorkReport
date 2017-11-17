package kr.co.e1.workreport.classificationdialog.adapter;

import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.adapter.SelectableItem;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class ClassificationSelectableItem extends SelectableItem<DetailWork> {
  @Accessors(chain = true) @Setter @Getter private String work;
  public ClassificationSelectableItem(DetailWork classificationCode, boolean isSelected) {
    super(classificationCode, isSelected);
  }
}
