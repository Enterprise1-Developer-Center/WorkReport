package kr.co.e1.workreport.statisticstotal;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;

/**
 * Created by jaeho on 2017. 11. 28
 */

public class TotalNetwork extends NetworkHelper {
  public TotalNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<List<TotalSummary>>> getSummaryTotal() {
    return getWorkReportApi().getSummaryTotal(PreferencesUtils.getToken(),
        PreferencesUtils.getDept());
  }
}
