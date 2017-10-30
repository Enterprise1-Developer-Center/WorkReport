package kr.co.e1.workreport.settings;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    SettingsActivityModule.class
}) public interface SettingsActivityComponent extends AndroidInjector<SettingsActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<SettingsActivity> {

  }
}
