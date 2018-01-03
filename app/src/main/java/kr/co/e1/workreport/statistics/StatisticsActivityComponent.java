package kr.co.e1.workreport.statistics;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.dialog_create.di.CreateDbProvider;
import kr.co.e1.workreport.statistics.operatio.OperationFragmentProvider;
import kr.co.e1.workreport.statistics.total.TotalFragmentProvider;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    StatisticsActivityModule.class, OperationFragmentProvider.class, TotalFragmentProvider.class,
    CreateDbProvider.class
}) public interface StatisticsActivityComponent extends AndroidInjector<StatisticsActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<StatisticsActivity> {

  }
}