package kr.co.e1.workreport.settings;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class SettingsActivityModule {

  @Provides SettingsPresenter.View provideSettingsView(SettingsActivity settingsActivity) {
    return settingsActivity;
  }

  @Provides SettingsPresenter provideSettingsPresenter(SettingsPresenter.View view) {
    return new SettingsPresenterImpl(view);
  }
}