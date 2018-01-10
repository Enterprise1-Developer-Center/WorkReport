package kr.co.e1.workreport.statistics.fm_total.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_total.model.TotalSummary;

/**
 * Created by jaeho on 2017. 11. 28
 */

public class TotalNetwork extends NetworkHelper<TotalApi> {
  public TotalNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<TotalApi> getApiClass() {
    return TotalApi.class;
  }

  public Single<WResult<List<TotalSummary>>> getSummaryTotal(int year) {
    return getApi().getSummaryTotal(PreferencesUtils.getToken(), PreferencesUtils.getDept(), year);
  }
}
