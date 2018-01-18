package kr.co.e1.workreport.projmanage.frag_proj.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;

/**
 * Created by jaeho on 2018. 1. 15
 */

public class ProjListNetwork extends NetworkHelper<ProjListApi> {
  public ProjListNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<ProjListApi> getApiClass() {
    return ProjListApi.class;
  }

  public Single<WResult<List<Project>>> getProjects2() {
    String header = PreferencesUtils.getToken();
    int code = PreferencesUtils.getDeptCd();
    return getApi().getProjects2(header, code);
  }

  public Single<WResult<List<Dept>>> getDepts() {
    return getApi().getDepts(PreferencesUtils.getToken());
  }

}
