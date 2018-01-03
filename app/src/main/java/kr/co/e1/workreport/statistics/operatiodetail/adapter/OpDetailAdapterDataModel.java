package kr.co.e1.workreport.statistics.operatiodetail.adapter;

import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.statistics.operatio.model.OpRatioTotal;

/**
 * Created by jaeho on 2017. 11. 23
 */

public interface OpDetailAdapterDataModel<T> extends BaseAdapterDataModel<T> {
  void addFooter(OpRatioTotal footer);
}
