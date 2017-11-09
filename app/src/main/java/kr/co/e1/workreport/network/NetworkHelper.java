package kr.co.e1.workreport.network;

import lombok.Getter;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaeho on 2017. 11. 8
 */

public class NetworkHelper {
  public final static int RESULT_SUCCESS = 1;
  public final static int RESULT_FAILURE = 0;
  private String baseUrl;

  @Getter private String confidentialsClient;
  @Getter private String grantType;
  @Getter private String scope;

  public NetworkHelper(String baseUrl) {
    this.baseUrl = baseUrl;
    confidentialsClient = Credentials.basic("test", "test");
    grantType = "client_credentials";
    scope = "RegisteredClient"; // Default
  }

  public WorkReportApi getWorkReportApi() {
    final Retrofit retrofit = createRetrofit();
    return retrofit.create(WorkReportApi.class);
  }

  private Retrofit createRetrofit() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(createClient())
        .build();

    return retrofit;
  }

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
}
