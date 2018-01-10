package kr.co.e1.workreport.teamreport.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.teamreport.model.TeamReportContent;

/**
 * Created by jaeho on 2017. 11. 20
 */

public class TeamReportNetwork extends NetworkHelper<TeamReportApi> {
  public TeamReportNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<TeamReportApi> getApiClass() {
    return TeamReportApi.class;
  }

  public Single<WResult<List<TeamReportContent>>> getSummary() {
    return getApi().getSummary(PreferencesUtils.getToken(), PreferencesUtils.getDept());
  }
}
