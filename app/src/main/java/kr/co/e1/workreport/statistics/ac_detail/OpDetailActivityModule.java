package kr.co.e1.workreport.statistics.ac_detail;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.statistics.ac_detail.adapter.OpDetailAdapter;
import kr.co.e1.workreport.statistics.ac_detail.adapter.OpDetailAdapterView;
import kr.co.e1.workreport.statistics.ac_detail.network.OpDetailNetwork;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class OpDetailActivityModule {

  @Provides OpDetailPresenter.View provideStatisticsView(OpDetailActivity opDetailActivity) {
    return opDetailActivity;
  }

  @Provides OpDetailPresenter provideStatisticsPresenter(OpDetailPresenter.View view,
      OpDetailActivity opDetailActivity, OpDetailNetwork network) {
    return new OpDetailPresenterImpl(view, opDetailActivity.adapter, network);
  }

  @Provides OpDetailAdapter provideOpDetailAdapter() {
    return new OpDetailAdapter();
  }

  @Provides OpDetailAdapterView provideAdapterView(OpDetailActivity activity) {
    return activity.adapter;
  }

  @Provides OpDetailNetwork provideOpDetailNetwork() {
    return new OpDetailNetwork(MyApplication.BASE_URL);
  }
}