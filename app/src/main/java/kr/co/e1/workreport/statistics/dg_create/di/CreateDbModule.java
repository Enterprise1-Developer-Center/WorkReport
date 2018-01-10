package kr.co.e1.workreport.statistics.dg_create.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.statistics.dg_create.CreateDbFragment;
import kr.co.e1.workreport.statistics.dg_create.CreateDbPresenter;
import kr.co.e1.workreport.statistics.dg_create.CreateDbPresenterImpl;
import kr.co.e1.workreport.statistics.dg_create.network.CreateDbNetwork;

/**
 * Created by jaeho on 2018. 1. 3
 */

@Module public class CreateDbModule {

  @Provides CreateDbPresenter provideCreateDbPresenter(CreateDbFragment fragment, CreateDbNetwork network) {
    return new CreateDbPresenterImpl(fragment, network);
  }

  @Provides CreateDbNetwork provideCreateDbNetwork() {
    return new CreateDbNetwork(MyApplication.BASE_URL);
  }
}
