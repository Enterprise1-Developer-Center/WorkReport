package kr.co.e1.workreport.main.dg_pass.network;

import io.reactivex.Single;
import kr.co.e1.workreport.network.WResult;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeho on 2018. 1. 10..
 */

public interface PasswordApi {

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/changePwd") Single<WResult> changePwd(
      @Header("Authorization") String header, @Field("userId") String userId,
      @Field("curPwd") String nowPw, @Field("newPwd") String newPw,
      @Field("newPwdConfirm") String newPwConfirm);

}
