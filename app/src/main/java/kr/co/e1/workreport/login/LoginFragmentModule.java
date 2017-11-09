package kr.co.e1.workreport.login;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.main.LoginCommunicationListener;
import kr.co.e1.workreport.network.NetworkHelper;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public class LoginFragmentModule {
  @Provides LoginFragmentPresenter.View provideLoginView(LoginFragment loginFragment) {
    return loginFragment;
  }

  @Provides NetworkHelper provideNetworkHelper(String baseUrl) {
    return new NetworkHelper(baseUrl);
  }

  @Provides String provideBaseUrl() {
    // Local - http://192.168.1.99:9080/mfp/
    return "http://211.219.71.228:9080/mfp/";
  }

  @Provides LoginCommunicationListener provideLoginCommunicationListener(
      LoginFragment loginFragment) {
    return loginFragment.loginCommunicationListener;
  }

  @Provides LoginFragmentPresenter provideLoginPresenter(LoginFragmentPresenter.View view,
      NetworkHelper networkHelper, LoginCommunicationListener loginListener) {
    return new LoginFragmentPresenterImpl(view, networkHelper, loginListener);
  }
}