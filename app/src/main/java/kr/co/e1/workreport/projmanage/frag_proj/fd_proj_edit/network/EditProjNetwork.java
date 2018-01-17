package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.network;

import io.reactivex.Single;
import java.util.HashMap;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class EditProjNetwork extends NetworkHelper<EditProjApi> {
  public EditProjNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<EditProjApi> getApiClass() {
    return EditProjApi.class;
  }

  public Single<WResult<List<Dept>>> getDepts() {
    return getApi().getDepts(PreferencesUtils.getToken());
  }

  public Single<WResult> editProject(HashMap<String, String> fieldMap) {
    String token = PreferencesUtils.getToken();
    return getApi().editProject(token, fieldMap);
  }

  public Single<WResult> delProject(String proj_cd) {
    String token = PreferencesUtils.getToken();
    return getApi().delProject(token, proj_cd);
  }
}
