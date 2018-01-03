package kr.co.e1.workreport.network;

import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.main.dialog_login.model.LoginContent;
import kr.co.e1.workreport.main.dialog_proje.vo.Project;
import kr.co.e1.workreport.statistics.operatio.model.OpRatioContent;
import kr.co.e1.workreport.statistics.total.model.TotalSummary;
import kr.co.e1.workreport.teamreport.model.TeamReportContent;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by jaeho on 2017. 11. 8
 */

public interface WorkReportApi {

  @FormUrlEncoded @POST("api/az/v1/token") Single<TokenResult> generateToken(
      @Header("Authorization") String header, @Field("grant_type") String grantTYpe,
      @Field("scope") String scope);

  /**
   * @param header Token
   */
  @GET("api/adapters/WorkReportSQL/login") Single<WResult<LoginContent>> getLoginResult(
      @Header("Authorization") String header, @QueryMap Map<String, String> queryMap);

  @GET("api/adapters/WorkReportSQL/getWorkingDay") Single<WResult<ReportContent>> getWorkingDay(
      @Header("Authorization") String header, @QueryMap Map<String, String> queryMap);

  @GET("api/adapters/WorkReportSQL/getCode") Single<WResult<List<DetailWork>>> getCode(
      @Header("Authorization") String header);

  @GET("api/adapters/WorkReportSQL/getProjects") Single<WResult<List<Project>>> getProjects(
      @Header("Authorization") String header);

  @GET("api/adapters/WorkReportSQL/getProjects") Single<WResult<List<Project>>> getProjects(
      @Header("Authorization") String header, @Query("DEPT_NM") String deptNm);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/updateWorkingDay")
  Single<WResult<ReportContent>> updateWorkingDay(@Header("Authorization") String header,
      @Field("LCLS_CD") String majorCode, @Field("MCLS_CD") String smallCode,
      @Field("DETAIL") String detailWork, @Field("PRJ_CD") String projectCode,
      @Field("S_TIME") String startTime, @Field("E_TIME") String endTime,
      @Field("UPD_TIME") String updateTime, @Field("USER_ID") String userId,
      @Field("date") String date);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/changePwd") Single<WResult> changePwd(
      @Header("Authorization") String header, @Field("userId") String userId,
      @Field("curPwd") String nowPw, @Field("newPwd") String newPw,
      @Field("newPwdConfirm") String newPwConfirm);

  @GET("api/adapters/WorkReportSQL/getSummary") Single<WResult<List<TeamReportContent>>> getSummary(
      @Header("Authorization") String header, @Query("DEPT_NM") String deptNm);

  @GET("api/adapters/WorkReportSQL/getOperRatio") Single<WResult<OpRatioContent>> getOperRatio(
      @Header("Authorization") String header, @Query("DEPT_NM") String deptNm,
      @Query("YEAR") int year);

  @GET("api/adapters/WorkReportSQL/getSummaryTotal")
  Single<WResult<List<TotalSummary>>> getSummaryTotal(@Header("Authorization") String header,
      @Query("DEPT_NM") String deptNm, @Query("YEAR") int year);

  @GET("api/adapters/WorkReportSQL/getAvailableStatisticsYear")
  Single<WResult<List<String>>> getAvailableStatisticsYear(@Header("Authorization") String header);
}
