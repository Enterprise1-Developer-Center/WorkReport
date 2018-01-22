package kr.co.e1.workreport.statistics.fm_operation.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.statistics.fm_operation.model.CurrOperationRate;
import kr.co.e1.workreport.statistics.fm_operation.model.YearOperationRate;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface OperationApi {

  @GET("api/adapters/WorkReportSQL/getCurrentOperationRate")
  Single<WResult<List<CurrOperationRate>>> getCurrentOperationRate(
      @Header("Authorization") String header, @Query("YEAR") int year,
      @Query("DEPT_CD") String deptCd);

  @GET("api/adapters/WorkReportSQL/getYearOperationRate")
  Single<WResult<List<YearOperationRate>>> getYearOperationRate(
      @Header("Authorization") String header, @Query("YEAR") int year,
      @Query("DEPT_CD") String deptCd);
}
