package kr.co.e1.workreport.main.dg_login;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public class LoginFragmentModule {
  @Provides LoginFragmentPresenter.View provideLoginView(LoginFragment loginFragment) {
    return loginFragment;
  }

  @Provides LoginNetwork provideNetworkHelper() {
    return new LoginNetwork(Constants.BASE_URL);
  }

  @Provides LoginCommunicationListener provideLoginCommunicationListener(
      LoginFragment loginFragment) {
    return loginFragment.loginCommunicationListener;
  }

  @Provides LoginFragmentPresenter provideLoginPresenter(LoginFragmentPresenter.View view,
      LoginNetwork network, LoginCommunicationListener loginListener) {
    return new LoginFragmentPresenterImpl(view, network, loginListener);
  }
}