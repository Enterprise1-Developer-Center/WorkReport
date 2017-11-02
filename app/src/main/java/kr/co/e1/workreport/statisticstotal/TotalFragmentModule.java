package kr.co.e1.workreport.statisticstotal;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class TotalFragmentModule {

  @Provides TotalFragmentPresenter.View provideTotalFragmentView(TotalFragment fragment) {
    return fragment;
  }

  @Provides TotalFragmentPresenter provideTotalFragmentPresenter(TotalFragmentPresenter.View view) {
    return new TotalFragmentPresenterImpl(view);
  }
}
