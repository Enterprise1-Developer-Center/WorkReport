package kr.co.e1.workreport.statistics.fm_operation;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.statistics.fm_operation.network.OperationNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class OperationFragmentModule {

  @Provides OperationFragmentPresenter.View provideOperationFragmentView(
      OperationFragment fragment) {
    return fragment;
  }

  @Provides OperationFragmentPresenter provideOperationFragmentPresenter(
      OperationFragmentPresenter.View view, OperationNetwork network, ChartDataGen chartDataGen) {
    return new OperationFragmentPresenterImpl(view, network, chartDataGen);
  }

  @Provides OperationNetwork provideOpRatioNetwork() {
    return new OperationNetwork(Constants.BASE_URL);
  }

  @Provides ChartDataGen provideChartDataGen(OperationFragment fragment) {
    return new ChartDataGen(fragment.getContext());
  }
}