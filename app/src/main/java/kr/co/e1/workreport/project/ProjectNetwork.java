package kr.co.e1.workreport.project;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.project.vo.Project;

/**
 * Created by jaeho on 2017. 11. 15
 */

public class ProjectNetwork extends NetworkHelper {
  public ProjectNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<List<Project>>> getProjects() {
    String header = PreferencesUtils.getToken();
    return getWorkReportApi().getProjects(header);
  }
}
