package kr.co.e1.workreport.statisticstotal;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.statisticstotal.adapter.TotalAdapter;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class TotalFragmentModule {

  @Provides TotalAdapter provideTotalAdapter() {
    return new TotalAdapter();
  }

  @Provides TotalFragmentPresenter provideTotalFragmentPresenter(TotalFragment fragment,
      TotalNetwork network) {
    return new TotalFragmentPresenterImpl(fragment, fragment.adapter, network);
  }

  @Provides TotalNetwork provideTotalNetwork() {
    return new TotalNetwork(Constants.BASE_URL);
  }

  @Provides BaseAdapterView provideBaseAdapterView(TotalFragment fragment) {
    return fragment.adapter;
  }
}
