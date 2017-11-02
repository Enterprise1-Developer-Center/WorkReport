package kr.co.e1.workreport.statisticstotal;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = TotalFragmentModule.class) public interface TotalFragmentComponent
    extends AndroidInjector<TotalFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<TotalFragment> {
  }
}
