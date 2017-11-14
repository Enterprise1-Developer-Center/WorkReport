package kr.co.e1.workreport.classificationdialog;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 14
 */

public class ClassificationNetwork extends NetworkHelper {
  public ClassificationNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<List<ClassificationCode>>> getCode() {
    return getWorkReportApi().getCode(PreferencesUtils.getToken());
  }
}
