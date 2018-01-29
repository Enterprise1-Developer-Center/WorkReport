package kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_holiday.model.LegalHoliday;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class EditHolidayNetwork extends NetworkHelper<EditHolidayApi> {
  public EditHolidayNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<EditHolidayApi> getApiClass() {
    return EditHolidayApi.class;
  }

  public Single<WResult<List<LegalHoliday>>> getLegalHolidays() {
    return getApi().getLegalHolidays(PreferencesUtils.getToken());
  }

  public Single<WResult> editHoliday(String date, String name) {
    return getApi().editHoliday(PreferencesUtils.getToken(), date, name);
  }

  public Single<WResult> delHoliday(String date) {
    return getApi().delHoliday(PreferencesUtils.getToken(), date);
  }
}