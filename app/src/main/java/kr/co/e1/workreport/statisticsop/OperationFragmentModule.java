package kr.co.e1.workreport.statisticsop;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class OperationFragmentModule {

  @Provides OperationFragmentPresenter.View provideOperationFragmentView(
      OperationFragment fragment) {
    return fragment;
  }

  @Provides OperationFragmentPresenter provideOperationFragmentPresenter(
      OperationFragmentPresenter.View view, OpRatioNetwork network) {
    return new OperationFragmentPresenterImpl(view, network);
  }

  @Provides OpRatioNetwork provideOpRatioNetwork() {
    return new OpRatioNetwork(Constants.BASE_URL);
  }
}
