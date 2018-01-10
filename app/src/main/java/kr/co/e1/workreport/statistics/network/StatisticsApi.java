package kr.co.e1.workreport.statistics.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface StatisticsApi {
  @GET("api/adapters/WorkReportSQL/getAvailableStatisticsYear")
  Single<WResult<List<String>>> getAvailableStatisticsYear(@Header("Authorization") String header);
}
