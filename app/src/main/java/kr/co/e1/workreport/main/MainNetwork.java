package kr.co.e1.workreport.main;

import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 13
 */

public class MainNetwork extends NetworkHelper {
  public MainNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<ReportContent>> getWorkingDay(String date) {
    Map<String, String> map = new HashMap<>();
    map.put("userId", PreferencesUtils.getUserId());
    map.put("date", date);
    return getWorkReportApi().getWorkingDay(PreferencesUtils.getToken(), map);
  }

  public Single<WResult<ReportContent>> updateWorkingDay(String majorCode, String smallCode,
      String work, String projectCode, String startTime, String endTime, String updateTime,
      String userId, String date) {
    return getWorkReportApi().updateWorkingDay(PreferencesUtils.getToken(), majorCode, smallCode,
        work, projectCode, startTime, endTime, updateTime, userId, date);
  }
}
