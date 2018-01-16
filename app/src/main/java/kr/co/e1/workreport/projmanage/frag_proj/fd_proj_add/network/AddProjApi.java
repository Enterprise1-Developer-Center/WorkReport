package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.network;

import io.reactivex.Single;
import java.util.HashMap;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeho on 2018. 1. 16
 */

public interface AddProjApi {
  @GET("api/adapters/WorkReportSQL/getDepts") Single<WResult<List<Dept>>> getDepts(
      @Header("Authorization") String header);

  @FormUrlEncoded @POST("api/adapters/WorkReportSQL/addProject")
  Single<WResult> addProject(@Header("Authorization") String header,
      @FieldMap HashMap<String, String> fieldMap);
}