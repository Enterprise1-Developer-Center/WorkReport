package kr.co.e1.workreport.statisticsopdetail.adapter;

import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.statisticsop.model.OpRatioHeader;
import kr.co.e1.workreport.statisticsop.model.OpRatioTotal;

/**
 * Created by jaeho on 2017. 11. 23
 */

public interface OpDetailAdapterDataModel<T> extends BaseAdapterDataModel<T> {
  void addHeader(OpRatioHeader header);

  void addFooter(OpRatioTotal footer);
}
