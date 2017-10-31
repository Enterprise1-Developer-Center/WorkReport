package kr.co.e1.workreport.teamreport;

import android.os.Bundle;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.teamreport.vo.TeamReport;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface TeamReportPresenter {

  void onCreated(Bundle savedInstanceState);

  void setAdapterDataModel(BaseAdapterDataModel<TeamReport> adapterDataModel);

  interface View {

    void setRecyclerView();

    void refresh();
  }
}
