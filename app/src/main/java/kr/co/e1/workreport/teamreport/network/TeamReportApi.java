package kr.co.e1.workreport.teamreport.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.teamreport.model.TeamReportContent;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface TeamReportApi {
  @GET("api/adapters/WorkReportSQL/getSummary")
  Single<WResult<List<TeamReportContent>>> getSummary(
      @Header("Authorization") String header, @Query("DEPT_NM") String deptNm);

}
