package kr.co.e1.workreport.statisticsgraph;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class GraphFragmentModule {

  @Provides GraphFragmentPresenter.View provideGraphFragmentView(
      GraphFragment fragment) {
    return fragment;
  }

  @Provides GraphFragmentPresenter provideGraphFragmentPresenter(
      GraphFragmentPresenter.View view) {
    return new GraphFragmentPresenterImpl(view);
  }
}
