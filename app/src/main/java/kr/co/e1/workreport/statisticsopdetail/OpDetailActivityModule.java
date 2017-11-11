package kr.co.e1.workreport.statisticsopdetail;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.statisticsopdetail.adapter.OpDetailAdapter;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class OpDetailActivityModule {

  @Provides OpDetailPresenter.View provideStatisticsView(OpDetailActivity opDetailActivity) {
    return opDetailActivity;
  }

  @Provides OpDetailPresenter provideStatisticsPresenter(OpDetailPresenter.View view,
      OpDetailActivity opDetailActivity) {
    return new OpDetailPresenterImpl(view, opDetailActivity.adapter);
  }

  @Provides OpDetailAdapter provideOpDetailAdapter() {
    return new OpDetailAdapter();
  }

  @Provides BaseAdapterView provideAdapterView(OpDetailActivity activity) {
    return activity.adapter;
  }
}