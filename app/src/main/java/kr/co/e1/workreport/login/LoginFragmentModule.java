package kr.co.e1.workreport.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 9. 27
 */
@Module public class LoginFragmentModule {

  @Provides LoginFragmentPresenter.View provideView(LoginFragment loginFragment) {
    return loginFragment;
  }

  @Provides LoginFragmentPresenter provideLoginPresenter(LoginFragmentPresenter.View view) {
    return new LoginFragmentPresenterImpl(view);
  }
}