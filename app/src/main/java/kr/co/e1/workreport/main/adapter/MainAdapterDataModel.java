package kr.co.e1.workreport.main.adapter;

import android.os.Bundle;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 11. 12
 */

public interface MainAdapterDataModel<T> extends BaseAdapterDataModel<T> {
  void edit(ReportType type, String contents);
  void edit(ReportType type, Project o);
}
