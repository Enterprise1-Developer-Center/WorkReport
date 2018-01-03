package kr.co.e1.workreport.teamreport.dialog;

import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 21
 */

public class TeamReportDialogNetwork extends NetworkHelper {
  public TeamReportDialogNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<ReportContent>> getWorkingDay(String date, String userId) {
    Map<String, String> map = new HashMap<>();
    map.put("userId", userId);
    map.put("date", date);
    return getWorkReportApi().getWorkingDay(PreferencesUtils.getToken(), map);
  }
}