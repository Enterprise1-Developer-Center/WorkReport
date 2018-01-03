package kr.co.e1.workreport.main.dialog_class;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 11. 14
 */

public class ClassificationNetwork extends NetworkHelper {
  public ClassificationNetwork(String baseUrl) {
    super(baseUrl);
  }

  public Single<WResult<List<DetailWork>>> getCode() {
    return getWorkReportApi().getCode(PreferencesUtils.getToken());
  }
}
