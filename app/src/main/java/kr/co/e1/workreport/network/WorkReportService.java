package kr.co.e1.workreport.network;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by jaeho on 2017. 11. 8
 */

public interface WorkReportService {

  @GET("/mfp/api/adapters/WorkReportSQL/login") Call<WLResult> getLoginResult(
      @QueryMap Map<String, String> queryMap);

  @FormUrlEncoded
  @POST("/mfp/api/az/v1/token") Call<MFPToken> generateToken(@Header("Authorization") String header,
      @Field("grant_type") String grantTYpe, @Field("scope") String scope);
}