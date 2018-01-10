package kr.co.e1.workreport.main.dg_proje.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.main.dg_proje.vo.Project;

/**
 * Created by jaeho on 2017. 11. 15
 */

public class ProjectNetwork extends NetworkHelper<ProjectApi> {
  public ProjectNetwork(String baseUrl) {
    super(baseUrl);
  }

  @Override protected Class<ProjectApi> getApiClass() {
    return ProjectApi.class;
  }

  public Single<WResult<List<Project>>> getProjects(String deptNm) {
    String header = PreferencesUtils.getToken();
    return getApi().getProjects(header, deptNm);
  }
}
