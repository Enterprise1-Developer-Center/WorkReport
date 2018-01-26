package kr.co.e1.workreport.statistics.fm_total.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.statistics.fm_total.TotalChartDataGen;
import kr.co.e1.workreport.statistics.fm_total.TotalFragment;
import kr.co.e1.workreport.statistics.fm_total.TotalFragmentPresenter;
import kr.co.e1.workreport.statistics.fm_total.TotalFragmentPresenterImpl;
import kr.co.e1.workreport.statistics.fm_total.network.TotalNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class TotalFragmentModule {


  @Provides TotalFragmentPresenter provideTotalFragmentPresenter(TotalFragment fragment,
      TotalNetwork network, TotalChartDataGen chartDataGen) {
    return new TotalFragmentPresenterImpl(fragment, network, chartDataGen);
  }

  @Provides TotalNetwork provideTotalNetwork() {
    return new TotalNetwork(MyApplication.BASE_URL);
  }

  @Provides TotalChartDataGen provideTotalChartDataGen(TotalFragment fragment) {
    return new TotalChartDataGen(fragment.getContext());
  }
}
