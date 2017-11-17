package kr.co.e1.workreport.project.adapter;

import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 11. 15
 */

public interface ProjectAdapterDataModel extends BaseAdapterDataModel<Project> {
  Project getSelectedItem();
}
