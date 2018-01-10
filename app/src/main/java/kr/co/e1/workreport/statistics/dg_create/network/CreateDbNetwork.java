package kr.co.e1.workreport.statistics.dg_create.network;

import io.reactivex.Single;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.dg_create.model.CreateDbYear;

/**
 * Created by jaeho on 2018. 1. 4
 */

public class CreateDbNetwork extends NetworkHelper<CreateDbApi> {
  public CreateDbNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<CreateDbApi> getApiClass() {
    return CreateDbApi.class;
  }

  public Single<WResult<CreateDbYear>> getCreateDbYear() {
    return getApi().getCreateDbYear(PreferencesUtils.getToken());
  }

  public Single<WResult<String>> createWorkCalendarDb(int year) {
    String token = PreferencesUtils.getToken();
    return getApi().createWorkCalendarDb(token, year, PreferencesUtils.getUserId());
  }
}
