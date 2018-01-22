package kr.co.e1.workreport.statistics.ac_detail.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.ac_detail.model.DetailOperationRate;

/**
 * Created by jaeho on 2018. 1. 9
 */

public class OpDetailNetwork extends NetworkHelper<OpDetailApi> {
  public OpDetailNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<OpDetailApi> getApiClass() {
    return OpDetailApi.class;
  }

  public Single<WResult<List<DetailOperationRate>>> getDetailOperationRate(int year) {
    String header = PreferencesUtils.getToken();
    String deptCd = PreferencesUtils.getDeptCd();
    return getApi().getDetailOperationRate(header, year, deptCd);
  }
}
