package kr.co.e1.workreport.classificationdialog.adapter;

import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 10. 25
 */

@AllArgsConstructor public class SelectableItem {
  @Getter private ClassificationCode classificationCode;
  @Getter @Setter private boolean isSelected = false;

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
