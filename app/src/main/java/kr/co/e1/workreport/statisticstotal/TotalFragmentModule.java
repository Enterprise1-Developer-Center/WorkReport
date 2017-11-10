package kr.co.e1.workreport.statisticstotal;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.statisticstotal.adapter.TotalAdapter;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class TotalFragmentModule {

  @Provides TotalAdapter provideTotalAdapter() {
    return new TotalAdapter();
  }

  @Provides TotalFragmentPresenter.View provideTotalFragmentView(TotalFragment fragment) {
    return fragment;
  }

  @Provides BaseAdapterView provideAdapterView(TotalFragment fragment) {
    return fragment.adapter;
  }

  @Provides TotalFragmentPresenter provideTotalFragmentPresenter(TotalFragmentPresenter.View view,
      TotalFragment fragment) {
    return new TotalFragmentPresenterImpl(view, fragment.adapter);
  }
}
