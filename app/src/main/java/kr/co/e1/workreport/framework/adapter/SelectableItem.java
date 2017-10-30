package kr.co.e1.workreport.framework.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jaeho on 2017. 10. 25
 */

@AllArgsConstructor public class SelectableItem<T> {
  @Getter private T item;
  @Getter @Setter private boolean isSelected = false;

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
