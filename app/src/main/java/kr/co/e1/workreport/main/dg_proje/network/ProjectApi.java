package kr.co.e1.workreport.main.dg_proje.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.main.dg_proje.vo.Project;
import kr.co.e1.workreport.network.WResult;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface ProjectApi {
  @GET("api/adapters/WorkReportSQL/getProjects") Single<WResult<List<Project>>> getProjects(
      @Header("Authorization") String header, @Query("DEPT_NM") String deptNm);
}
