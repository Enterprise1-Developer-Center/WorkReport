package kr.co.e1.workreport.main.dialog_proje.adapter;

import kr.co.e1.workreport.framework.adapter.SelectableItem;
import kr.co.e1.workreport.main.dialog_proje.vo.Project;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class ProjectSelectableItem extends SelectableItem<Project> {
  public ProjectSelectableItem(Project project, boolean isSelected) {
    super(project, isSelected);
  }
}
