package kr.co.e1.workreport.projmanage.frag_emp.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class EmpListNetwork extends NetworkHelper<EmpListApi> {
  public EmpListNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<EmpListApi> getApiClass() {
    return EmpListApi.class;
  }

  public Single<WResult<List<Employee>>> getEmployees() {
    return getApi().getEmployees(PreferencesUtils.getToken());
  }
}
