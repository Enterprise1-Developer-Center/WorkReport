package kr.co.e1.workreport.statistics;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = { StatisticsActivityModule.class })
public interface StatisticsActivityComponent extends AndroidInjector<StatisticsActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<StatisticsActivity> {

  }
}
