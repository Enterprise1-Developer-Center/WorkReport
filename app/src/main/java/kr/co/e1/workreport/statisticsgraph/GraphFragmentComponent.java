package kr.co.e1.workreport.statisticsgraph;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = GraphFragmentModule.class) public interface GraphFragmentComponent
    extends AndroidInjector<GraphFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<GraphFragment> {
  }
}
