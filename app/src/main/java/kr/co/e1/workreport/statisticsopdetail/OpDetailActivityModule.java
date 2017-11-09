package kr.co.e1.workreport.statisticsopdetail;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class OpDetailActivityModule {

  @Provides OpDetailPresenter.View provideStatisticsView(OpDetailActivity opDetailActivity) {
    return opDetailActivity;
  }

  @Provides OpDetailPresenter provideStatisticsPresenter(OpDetailPresenter.View view) {
    return new OpDetailPresenterImpl(view);
  }
}