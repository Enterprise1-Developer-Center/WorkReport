package kr.co.e1.workreport.classificationcode.adapter;

import kr.co.e1.workreport.classificationcode.vo.ClassificationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 10. 25
 */

@AllArgsConstructor public class SelectableItem {
  @Getter @Setter private boolean isSelected = false;
  @Getter private ClassificationCode classificationCode;
  @Getter @Setter private boolean requestFocus;

  SelectableItem(ClassificationCode code, boolean isSelected) {
    this.classificationCode = code;
    this.isSelected = isSelected;
  }

  public boolean equals(String code) {
    if (classificationCode != null && classificationCode.getCode() != null && code != null) {
      if (classificationCode.getCode().equals(code)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public boolean equals(SelectableItem item) {
    if (item != null) {
      if (item == this) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
