package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.network;

import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class EditEmpNetwork extends NetworkHelper<EditEmpApi> {
  public EditEmpNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<EditEmpApi> getApiClass() {
    return EditEmpApi.class;
  }

  public Single<WResult<List<User>>> getUsers() {
    return getApi().getUsers(PreferencesUtils.getToken());
  }

  public Single<WResult<List<Project>>> getProjects2() {
    String deptCd = PreferencesUtils.getDeptCd();
    return getApi().getProjects2(PreferencesUtils.getToken(), deptCd);
  }

  public Single<WResult<List<DetailWork>>> getCode() {
    return getApi().getCode(PreferencesUtils.getToken());
  }

  public Single<WResult> editEmployee(Map<String, String> fieldMap) {
    return getApi().editEmployee(PreferencesUtils.getToken(), fieldMap);
  }

  public Single<WResult> delEmployee(Map<String, String> fieldMap) {
    return getApi().delEmployee(PreferencesUtils.getToken(), fieldMap);
  }
}
