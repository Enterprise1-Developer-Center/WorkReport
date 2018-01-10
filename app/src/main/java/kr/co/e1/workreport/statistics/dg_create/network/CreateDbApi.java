package kr.co.e1.workreport.statistics.dg_create.network;

import io.reactivex.Single;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.dg_create.model.CreateDbYear;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface CreateDbApi {

  @GET("api/adapters/WorkReportSQL/getCreateDbYear") Single<WResult<CreateDbYear>> getCreateDbYear(
      @Header("Authorization") String header);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/createWorkCalendarDb")
  Single<WResult<String>> createWorkCalendarDb(@Header("Authorization") String header,
      @Field("YEAR") int year, @Field("USER_ID") String userId);

}
