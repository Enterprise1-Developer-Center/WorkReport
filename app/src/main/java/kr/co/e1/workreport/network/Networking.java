package kr.co.e1.workreport.network;

/*
 * Created by jaeho on 2017. 11. 8
 */

import java.util.HashMap;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networking {
  private String baseUrl;

  public Networking(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public Retrofit createRetrofit() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(createClient())
        .build();
    return retrofit;
  }

  public void req() {
    WorkReportService service = createRetrofit().create(WorkReportService.class);
    Map<String, String> loginMap = new HashMap<>();
    loginMap.put("userId", "jhoh");
    loginMap.put("userPw", "1112");
    /*
    Call<WLResult> resultCall = service.getLoginResult("Bearer " + key, loginMap);
    resultCall.enqueue(new Callback<WLResult>() {
      @Override public void onResponse(Call<WLResult> call, Response<WLResult> response) {
        Timber.d(response.toString());
      }

      @DebugLog @Override public void onFailure(Call<WLResult> call, Throwable t) {

      }
    });
    */
  }

  private String key = "";

  private OkHttpClient createClient() {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(chain -> {
      Request original = chain.request();
      Request.Builder requestBuilder =
          original.newBuilder().header("Content-Type", "application/x-www-form-urlencoded");

      Request request = requestBuilder.build();
      return chain.proceed(request);
    });
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    httpClient.addInterceptor(interceptor);
    OkHttpClient client = httpClient.build();
    return client;
  }

  public void getToken() {

    WorkReportService service =
        createRetrofit().create(WorkReportService.class);//client_credentials

    /*
    Call<TokenResult> resultCall =
        service.generateToken(Credentials.basic("test", "test"), "client_credentials", "");
    resultCall.enqueue(new Callback<TokenResult>() {
      @Override public void onResponse(Call<TokenResult> call, Response<TokenResult> response) {
        Timber.d(response.body().toString());
        key = response.body().getAccess_token();
      }

      @Override public void onFailure(Call<TokenResult> call, Throwable t) {

      }
    });
    */
  }
}