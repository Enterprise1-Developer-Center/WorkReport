package kr.co.e1.workreport.network;

/*
 * Created by jaeho on 2017. 11. 8
 */

import hugo.weaving.DebugLog;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networking {

  @DebugLog public static void req() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.99:9080")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();

    WorkReportService service = retrofit.create(WorkReportService.class);
    Map<String, String> loginMap = new HashMap<>();
    loginMap.put("userId", "jhoh");
    loginMap.put("userPw", "1112");
    Call<WLResult> resultCall = service.getLoginResult(loginMap);
    resultCall.enqueue(new Callback<WLResult>() {
      @DebugLog @Override public void onResponse(Call<WLResult> call, Response<WLResult> response) {

      }

      @DebugLog @Override public void onFailure(Call<WLResult> call, Throwable t) {

      }
    });
  }

  @DebugLog public static void getToken() {

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    /*
    httpClient.addInterceptor(new Interceptor() {
      @Override public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        // Request customization: add request headers
        Request.Builder requestBuilder =
            original.newBuilder().header("Content-Type", "application/x-www-form-urlencoded");

        Request request = requestBuilder.build();
        return chain.proceed(request);
      }
    });
    */
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    httpClient.addInterceptor(interceptor);
    OkHttpClient client = httpClient.build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.99:9080")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();

    WorkReportService service = retrofit.create(WorkReportService.class);//client_credentials

    Call<MFPToken> resultCall =
        service.generateToken(Credentials.basic("test", "test"), "client_credentials", "");
    resultCall.enqueue(new Callback<MFPToken>() {
      @DebugLog @Override public void onResponse(Call<MFPToken> call, Response<MFPToken> response) {
        MFPToken body = response.body();
      }

      @DebugLog @Override public void onFailure(Call<MFPToken> call, Throwable t) {

      }
    });
  }
}