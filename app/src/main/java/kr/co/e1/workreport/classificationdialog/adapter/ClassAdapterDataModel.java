package kr.co.e1.workreport.classificationdialog.adapter;

import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;

/**
 * Created by jaeho on 2017. 11. 15
 */

public interface ClassAdapterDataModel extends BaseAdapterDataModel<DetailWork> {
  ClassificationSelectableItem getSelectedItem();
}
