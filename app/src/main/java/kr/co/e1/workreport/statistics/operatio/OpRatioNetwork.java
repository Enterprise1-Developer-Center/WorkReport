package kr.co.e1.workreport.statistics.operatio;

import io.reactivex.Single;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.operatio.model.OpRatioContent;

/**
 * Created by jaeho on 2017. 11. 22
 */

public class OpRatioNetwork extends NetworkHelper {
  public OpRatioNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<OpRatioContent>> getOperRatio() {
    String header = PreferencesUtils.getToken();
    String deptNm = PreferencesUtils.getDept();
    int year = 2017;
    return getWorkReportApi().getOperRatio(header, deptNm, year);
  }
}
