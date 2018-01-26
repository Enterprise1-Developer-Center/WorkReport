package kr.co.e1.workreport.statistics.fm_holiday.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class HolidayNetwork extends NetworkHelper<HolidayApi> {
  public HolidayNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<HolidayApi> getApiClass() {
    return HolidayApi.class;
  }

  public Single<WResult<List<Holiday>>> getHolidays(int year) {
    String header = PreferencesUtils.getToken();
    return getApi().getHolidays(header, year);
  }
}
