package kr.co.e1.workreport.statistics.fm_operatio;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_operatio.model.CurrOperationRate;
import kr.co.e1.workreport.statistics.fm_operatio.model.OpRatioContent;
import kr.co.e1.workreport.statistics.fm_operatio.model.YearOperationRate;

/**
 * Created by jaeho on 2017. 11. 22
 */

public class OperationNetwork extends NetworkHelper {
  public OperationNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<OpRatioContent>> getOperRatio(int year) {
    String header = PreferencesUtils.getToken();
    String deptNm = PreferencesUtils.getDept();
    return getWorkReportApi().getOperRatio(header, deptNm, year);
  }

  public Single<WResult<List<CurrOperationRate>>> getCurrentOperationRate(int year) {
    String header = PreferencesUtils.getToken();
    int code = PreferencesUtils.getDeptCd();
    return getWorkReportApi().getCurrentOperationRate(header, year, code);
  }

  public Single<WResult<List<YearOperationRate>>> getYearOperationRate(int year) {
    String header = PreferencesUtils.getToken();
    int code = PreferencesUtils.getDeptCd();
    return getWorkReportApi().getYearOperationRate(header, year, code);
  }
}
