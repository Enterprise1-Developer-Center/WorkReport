package kr.co.e1.workreport.main.dialog_proje;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;
import kr.co.e1.workreport.main.dialog_proje.vo.Project;

/**
 * Created by jaeho on 2017. 11. 15
 */

public class ProjectNetwork extends NetworkHelper {
  public ProjectNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<List<Project>>> getProjects(String deptNm) {
    String header = PreferencesUtils.getToken();
    return getWorkReportApi().getProjects(header, deptNm);
  }

}
