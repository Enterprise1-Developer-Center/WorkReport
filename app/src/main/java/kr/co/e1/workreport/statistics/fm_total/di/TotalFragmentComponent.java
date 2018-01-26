package kr.co.e1.workreport.statistics.fm_total.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.fm_total.TotalFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = TotalFragmentModule.class) public interface TotalFragmentComponent
    extends AndroidInjector<TotalFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<TotalFragment> {
  }
}
