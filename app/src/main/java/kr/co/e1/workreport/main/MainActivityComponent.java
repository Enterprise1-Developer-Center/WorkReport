package kr.co.e1.workreport.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = { MainActivityModule.class, LoginFragmentProvider.class })
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<MainActivity> {

  }
}
