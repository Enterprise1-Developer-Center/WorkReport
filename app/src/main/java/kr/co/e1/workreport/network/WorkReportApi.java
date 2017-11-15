package kr.co.e1.workreport.network;

import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.common.model.ReportContent;
import kr.co.e1.workreport.login.model.LoginContent;
import kr.co.e1.workreport.project.vo.Project;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by jaeho on 2017. 11. 8
 */

public interface WorkReportApi {

  @FormUrlEncoded @POST("api/az/v1/token") Single<TokenResult> generateToken(
      @Header("Authorization") String header, @Field("grant_type") String grantTYpe,
      @Field("scope") String scope);

  @GET("api/adapters/WorkReportSQL/login") Single<WResult<LoginContent>> getLoginResult(
      @Header("Authorization") String header, @QueryMap Map<String, String> queryMap);

  @GET("api/adapters/WorkReportSQL/getWorkingDay") Single<WResult<ReportContent>> getWorkingDay(
      @Header("Authorization") String header, @QueryMap Map<String, String> queryMap);

  @GET("api/adapters/WorkReportSQL/getCode") Single<WResult<List<ClassificationCode>>> getCode(
      @Header("Authorization") String header);

  @GET("api/adapters/WorkReportSQL/getProjects") Single<WResult<List<Project>>> getProjects(
      @Header("Authorization") String header);
}