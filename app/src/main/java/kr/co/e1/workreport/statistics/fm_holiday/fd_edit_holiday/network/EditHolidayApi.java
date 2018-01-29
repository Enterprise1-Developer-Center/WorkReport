package kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_holiday.model.LegalHoliday;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface EditHolidayApi {

  @GET("api/adapters/WorkReportSQL/getLegalHolidays")
  Single<WResult<List<LegalHoliday>>> getLegalHolidays(@Header("Authorization") String header);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/editHoliday") Single<WResult> editHoliday(
      @Header("Authorization") String header, @Field("WORK_YMD") String date,
      @Field("HOLIDAY_NM") String name);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/delHoliday") Single<WResult> delHoliday(
      @Header("Authorization") String header, @Field("WORK_YMD") String date);
}