package kr.co.e1.workreport.statistics;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.statisticsoperation.OperationFragmentComponent;
import kr.co.e1.workreport.statisticstotal.TotalFragmentComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    OperationFragmentComponent.class, TotalFragmentComponent.class
}) public class StatisticsActivityModule {

  @Provides StatisticsPresenter.View provideStatisticsView(StatisticsActivity statisticsActivity) {
    return statisticsActivity;
  }

  @Provides StatisticsPresenter provideStatisticsPresenter(StatisticsPresenter.View view) {
    return new StatisticsPresenterImpl(view);
  }
}