package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.network;

import kr.co.e1.workreport.network.NetworkHelper;

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

}
