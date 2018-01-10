package kr.co.e1.workreport.main.dg_class.network;

import io.reactivex.Single;
import java.util.List;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.network.WResult;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by jaeho on 2018. 1. 10
 */

public interface ClassificationApi {

  @GET("api/adapters/WorkReportSQL/getCode") Single<WResult<List<DetailWork>>> getCode(
      @Header("Authorization") String header);

}
