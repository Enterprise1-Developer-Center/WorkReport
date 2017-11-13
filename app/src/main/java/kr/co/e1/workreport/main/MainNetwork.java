package kr.co.e1.workreport.main;

import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WLResult;

/**
 * Created by jaeho on 2017. 11. 13
 */

public class MainNetwork extends NetworkHelper {
  public MainNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WLResult> getWorkingDay(String date) {
    Map<String, String> map = new HashMap<>();
    map.put("userId", PreferencesUtils.getUserId());
    map.put("date", date);
    return getWorkReportApi().getWorkingDay(PreferencesUtils.getToken(), map);
  }
}
