package kr.co.e1.workreport.statistics.fm_total.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_total.model.TotalSummary;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 10..
 */

public interface TotalApi {
  @GET("api/adapters/WorkReportSQL/getSummaryTotal")
  Single<WResult<List<TotalSummary>>> getSummaryTotal(@Header("Authorization") String header,
      @Query("DEPT_NM") String deptNm, @Query("YEAR") int year);

}
