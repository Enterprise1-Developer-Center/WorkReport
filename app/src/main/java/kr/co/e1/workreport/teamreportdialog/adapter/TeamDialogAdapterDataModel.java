package kr.co.e1.workreport.teamreportdialog.adapter;

import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;

/**
 * Created by jaeho on 2017. 11. 21
 */

public interface TeamDialogAdapterDataModel<T> extends BaseAdapterDataModel<T> {
  void edit(ReportType type, String content);
}
