package kr.co.e1.workreport.projmanage.frag_emp.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by jaeho on 2018. 1. 15
 */

public interface EmpListApi {
  @GET("api/adapters/WorkReportSQL/getEmployees") Single<WResult<List<Employee>>> getEmployees(
      @Header("Authorization") String header);
}
