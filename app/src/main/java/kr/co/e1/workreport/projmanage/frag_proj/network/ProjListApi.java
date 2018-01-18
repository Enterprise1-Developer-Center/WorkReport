package kr.co.e1.workreport.projmanage.frag_proj.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 15..
 */

public interface ProjListApi {
  @GET("api/adapters/WorkReportSQL/getProjects2") Single<WResult<List<Project>>> getProjects2(
      @Header("Authorization") String header, @Query("DEPT_CD") int deptCD);

  @GET("api/adapters/WorkReportSQL/getDepts") Single<WResult<List<Dept>>> getDepts(
      @Header("Authorization") String header);
}
