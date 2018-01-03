package kr.co.e1.workreport.statistics.dialog_create.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.statistics.dialog_create.CreateDbFragment;
import kr.co.e1.workreport.statistics.dialog_create.CreateDbPresenter;
import kr.co.e1.workreport.statistics.dialog_create.CreateDbPresenterImpl;

/**
 * Created by jaeho on 2018. 1. 3
 */

@Module public class CreateDbModule {

  @Provides CreateDbPresenter provideCreateDbPresenter(CreateDbFragment fragment) {
    return new CreateDbPresenterImpl(fragment);
  }
}
