package kr.co.e1.workreport.statistics;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class StatisticsActivityModule {

  @Provides StatisticsPresenter.View provideStatisticsView(StatisticsActivity statisticsActivity) {
    return statisticsActivity;
  }

  @Provides StatisticsPresenter provideStatisticsPresenter(StatisticsPresenter.View view) {
    return new StatisticsPresenterImpl(view);
  }
}