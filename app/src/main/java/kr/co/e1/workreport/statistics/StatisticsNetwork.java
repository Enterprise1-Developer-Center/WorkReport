package kr.co.e1.workreport.statistics;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 12. 26
 */

public class StatisticsNetwork extends NetworkHelper {
  public StatisticsNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<List<String>>> getAvailableStatisticsYear() {
    String token = PreferencesUtils.getToken();
    return getWorkReportApi().getAvailableStatisticsYear(token);
  }
}
