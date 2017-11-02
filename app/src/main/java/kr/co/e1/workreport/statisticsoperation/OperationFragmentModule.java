package kr.co.e1.workreport.statisticsoperation;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class OperationFragmentModule {

  @Provides OperationFragmentPresenter.View provideOperationFragmentView(
      OperationFragment fragment) {
    return fragment;
  }

  @Provides OperationFragmentPresenter provideOperationFragmentPresenter(
      OperationFragmentPresenter.View view) {
    return new OperationFragmentPresenterImpl(view);
  }
}
