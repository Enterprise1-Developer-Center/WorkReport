package kr.co.e1.workreport.statistics.fm_operation.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_operation.model.CurrOperationRate;
import kr.co.e1.workreport.statistics.fm_operation.model.YearOperationRate;

/**
 * Created by jaeho on 2017. 11. 22
 */

public class OperationNetwork extends NetworkHelper<OperationApi> {
  public OperationNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<OperationApi> getApiClass() {
    return OperationApi.class;
  }

  public Single<WResult<List<CurrOperationRate>>> getCurrentOperationRate(int year) {
    String header = PreferencesUtils.getToken();
    String deptCd = PreferencesUtils.getDeptCd();
    return getApi().getCurrentOperationRate(header, year, deptCd);
  }

  public Single<WResult<List<YearOperationRate>>> getYearOperationRate(int year) {
    String header = PreferencesUtils.getToken();
    String deptCd = PreferencesUtils.getDeptCd();
    return getApi().getYearOperationRate(header, year, deptCd);
  }
}
