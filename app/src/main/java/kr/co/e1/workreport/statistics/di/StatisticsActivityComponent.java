package kr.co.e1.workreport.statistics.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.StatisticsActivity;
import kr.co.e1.workreport.statistics.dg_create.di.CreateDbProvider;
import kr.co.e1.workreport.statistics.fm_operation.di.OperationFragmentProvider;
import kr.co.e1.workreport.statistics.fm_total.di.TotalFragmentProvider;

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