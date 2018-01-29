package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_holiday.model.LegalHoliday;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddHolidayNetwork extends NetworkHelper<AddHolidayApi> {
  public AddHolidayNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<AddHolidayApi> getApiClass() {
    return AddHolidayApi.class;
  }

  public Single<WResult<List<LegalHoliday>>> getLegalHolidays() {
    return getApi().getLegalHolidays(PreferencesUtils.getToken());
  }

  public Single<WResult> addHoliday(String date, String name) {
    return getApi().addHoliday(PreferencesUtils.getToken(), date, name);
  }
}