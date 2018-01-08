package kr.co.e1.workreport.statistics.operatiodetail;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.statistics.fm_operatio.OpRatioNetwork;
import kr.co.e1.workreport.statistics.operatiodetail.adapter.OpDetailAdapter;
import kr.co.e1.workreport.statistics.operatiodetail.adapter.OpDetailAdapterView;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class OpDetailActivityModule {

  @Provides OpDetailPresenter.View provideStatisticsView(OpDetailActivity opDetailActivity) {
    return opDetailActivity;
  }

  @Provides OpDetailPresenter provideStatisticsPresenter(OpDetailPresenter.View view,
      OpDetailActivity opDetailActivity, OpRatioNetwork network) {
    return new OpDetailPresenterImpl(view, opDetailActivity.adapter, network);
  }

  @Provides OpDetailAdapter provideOpDetailAdapter() {
    return new OpDetailAdapter();
  }

  @Provides OpDetailAdapterView provideAdapterView(OpDetailActivity activity) {
    return activity.adapter;
  }

  @Provides OpRatioNetwork provideOpRatioNetwork() {
    return new OpRatioNetwork(Constants.BASE_URL);
  }
}