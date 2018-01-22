package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.model.UserType;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddEmpNetwork extends NetworkHelper<AddEmpApi> {
  public AddEmpNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<AddEmpApi> getApiClass() {
    return AddEmpApi.class;
  }

  public Single<WResult<List<User>>> getUsers() {
    return getApi().getUsers(PreferencesUtils.getToken());
  }

  public Single<WResult<List<Project>>> getProjects2() {
    String deptCd = PreferencesUtils.getDeptCd();
    return getApi().getProjects2(PreferencesUtils.getToken(), deptCd);
  }

  public Single<WResult<List<UserType>>> getUserTypes() {
    return getApi().getUserTypes(PreferencesUtils.getToken());
  }

  public Single<WResult<List<DetailWork>>> getCode() {
    return getApi().getCode(PreferencesUtils.getToken());
  }
}
