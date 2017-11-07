package kr.co.e1.workreport.login;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public class LoginFragmentModule {
  private final static String BASE_URL = "/adapters/WorkReportSQL/";
  @Provides LoginFragmentPresenter.View provideLoginView(LoginFragment loginFragment) {
    return loginFragment;
  }
  @Provides LoginNetworking provideLoginNetwork(String url) {
    return new LoginNetworking(url);
  }

  @Provides String provideLoginUrl() {
    return BASE_URL + "login";
  }
  @Provides LoginCommunicationListener provideLoginCommunicationListener(LoginFragment loginFragment) {
    return loginFragment.loginCommunicationListener;
  }
  @Provides LoginFragmentPresenter provideLoginPresenter(LoginFragmentPresenter.View view, LoginNetworking networking, LoginCommunicationListener loginListener) {
    return new LoginFragmentPresenterImpl(view, networking, loginListener);
  }
}