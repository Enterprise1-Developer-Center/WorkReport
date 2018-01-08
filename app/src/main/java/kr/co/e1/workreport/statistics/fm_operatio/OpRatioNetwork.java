package kr.co.e1.workreport.statistics.fm_operatio;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_operatio.model.OpRatioContent;
import kr.co.e1.workreport.statistics.fm_operatio.model.YearOperationRatio;

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

  public Single<WResult<List<YearOperationRatio>>> getYearOperationRatio(int year) {
    String header = PreferencesUtils.getToken();
    return getWorkReportApi().getYearOperatingRatio(header, year);
  }
}
