package kr.co.e1.workreport.network;

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

public abstract class NetworkHelper<T> {
  public final static int RESULT_SUCCESS = 1;
  public final static int RESULT_FAILURE = 0;
  public final static int DELAY = 0;
  protected final static String confidentialsClient = Credentials.basic("test", "test");
  protected final static String grantType = "client_credentials";
  protected final String scope = "RegisteredClient";

  private String baseUrl;

  public NetworkHelper(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public T getApi() {
    return createRetrofit().create(getApiClass());
  }

  protected abstract Class<T> getApiClass();

  protected Retrofit createRetrofit() {
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
