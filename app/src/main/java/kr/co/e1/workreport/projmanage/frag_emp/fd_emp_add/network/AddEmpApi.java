package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.network;

import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.model.UserType;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddEmpApi {
  @GET("api/adapters/WorkReportSQL/getUsers") Single<WResult<List<User>>> getUsers(
      @Header("Authorization") String header);

  @GET("api/adapters/WorkReportSQL/getProjects2") Single<WResult<List<Project>>> getProjects2(
      @Header("Authorization") String header, @Query("DEPT_CD") String deptCd);

  @GET("api/adapters/WorkReportSQL/getUserTypes") Single<WResult<List<UserType>>> getUserTypes(
      @Header("Authorization") String header);

  @GET("api/adapters/WorkReportSQL/getCode") Single<WResult<List<DetailWork>>> getCode(
      @Header("Authorization") String header);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/addEmployee") Single<WResult> addEmployee(
      @Header("Authorization") String header, @FieldMap Map<String, String> fieldMap);
}