package kr.co.e1.workreport.main.dg_login.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import javax.inject.Singleton;
import kr.co.e1.workreport.main.dg_login.LoginFragment;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Singleton @Subcomponent(modules = LoginFragmentModule.class) public interface LoginFragmentComponent
    extends AndroidInjector<LoginFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<LoginFragment> {

  }
}