package kr.co.e1.workreport.main.network;

import io.reactivex.Single;
import java.util.Map;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.network.WResult;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface MainApi {

  @GET("api/adapters/WorkReportSQL/getWorkingDay") Single<WResult<ReportContent>> getWorkingDay(
      @Header("Authorization") String header, @QueryMap Map<String, String> queryMap);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/updateWorkingDay")
  Single<WResult<ReportContent>> updateWorkingDay(@Header("Authorization") String header,
      @Field("LCLS_CD") String majorCode, @Field("MCLS_CD") String smallCode,
      @Field("DETAIL") String detailWork, @Field("PROJ_CD") String projectCode,
      @Field("S_TIME") String startTime, @Field("E_TIME") String endTime,
      @Field("UPD_TIME") String updateTime, @Field("USER_ID") String userId,
      @Field("date") String date);

}
