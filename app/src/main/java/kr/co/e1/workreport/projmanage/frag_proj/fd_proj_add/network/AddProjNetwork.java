package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;

/**
 * Created by jaeho on 2018. 1. 16..
 */

public class AddProjNetwork extends NetworkHelper<AddProjApi> {
  public AddProjNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<AddProjApi> getApiClass() {
    return AddProjApi.class;
  }

  public Single<WResult<List<Dept>>> getDepts() {
    return getApi().getDepts(PreferencesUtils.getToken());
  }
}
