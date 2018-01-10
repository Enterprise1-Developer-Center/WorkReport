package kr.co.e1.workreport.statistics.ac_detail.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.network.WorkReportApi;
import kr.co.e1.workreport.statistics.ac_detail.model.DetailOperationRate;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface OpDetailApi extends WorkReportApi {
  @GET("api/adapters/WorkReportSQL/getDetailOperationRate")
  Single<WResult<List<DetailOperationRate>>> getDetailOperationRate(
      @Header("Authorization") String header, @Query("YEAR") int year, @Query("DEPT_CD") int code);
}
