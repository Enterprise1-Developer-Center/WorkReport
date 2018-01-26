package kr.co.e1.workreport.statistics.fm_holiday.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 15
 */

public interface HolidayApi {
  @GET("api/adapters/WorkReportSQL/getHolidays") Single<WResult<List<Holiday>>> getHolidays(
      @Header("Authorization") String header, @Query("YEAR") int year);
}
