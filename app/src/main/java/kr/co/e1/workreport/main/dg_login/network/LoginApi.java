package kr.co.e1.workreport.main.dg_login.network;

import io.reactivex.Single;
import java.util.Map;
import kr.co.e1.workreport.main.dg_login.model.LoginContent;
import kr.co.e1.workreport.network.TokenResult;
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

public interface LoginApi {

  @FormUrlEncoded @POST("api/az/v1/token") Single<TokenResult> generateToken(
      @Header("Authorization") String header, @Field("grant_type") String grantTYpe,
      @Field("scope") String scope);

  /**
   * @param header Token
   */
  @GET("api/adapters/WorkReportSQL/login") Single<WResult<LoginContent>> getLoginResult(
      @Header("Authorization") String header, @QueryMap Map<String, String> queryMap);

}
