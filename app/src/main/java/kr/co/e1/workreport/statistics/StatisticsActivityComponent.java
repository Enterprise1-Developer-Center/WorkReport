package kr.co.e1.workreport.statistics;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statisticsoperation.OperationFragmentProvider;
import kr.co.e1.workreport.statisticstotal.TotalFragmentProvider;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    StatisticsActivityModule.class, OperationFragmentProvider.class, TotalFragmentProvider.class
}) public interface StatisticsActivityComponent extends AndroidInjector<StatisticsActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<StatisticsActivity> {

  }
}