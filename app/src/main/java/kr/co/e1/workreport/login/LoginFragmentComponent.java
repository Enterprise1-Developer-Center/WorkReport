package kr.co.e1.workreport.login;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Subcomponent(modules = LoginFragmentModule.class) public interface LoginFragmentComponent
    extends AndroidInjector<LoginFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<LoginFragment> {

  }
}
