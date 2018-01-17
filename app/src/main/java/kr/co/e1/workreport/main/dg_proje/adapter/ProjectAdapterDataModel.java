package kr.co.e1.workreport.main.dg_proje.adapter;

import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.main.dg_proje.model.Project;

/**
 * Created by jaeho on 2017. 11. 15
 */

public interface ProjectAdapterDataModel extends BaseAdapterDataModel<Project> {
  Project getSelectedItem();
}
