package kr.co.e1.workreport.statistics.dialog_create;

import io.reactivex.Single;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.dialog_create.model.CreateDbYear;

/**
 * Created by jaeho on 2018. 1. 4
 */

public class CreateDbNetwork extends NetworkHelper {
  public CreateDbNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<CreateDbYear>> getCreateDbYear() {
    return getWorkReportApi().getCreateDbYear(PreferencesUtils.getToken());
  }

  public Single<WResult> createWorkCalendarDb() {
    String token = PreferencesUtils.getToken();
    return getWorkReportApi().createWorkCalendarDb(token, PreferencesUtils.getDept());
  }
}
