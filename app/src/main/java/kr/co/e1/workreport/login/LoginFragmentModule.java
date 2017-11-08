package kr.co.e1.workreport.login;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public class LoginFragmentModule {
  @Provides LoginFragmentPresenter.View provideLoginView(LoginFragment loginFragment) {
    return loginFragment;
  }
  @Provides LoginNetworking provideLoginNetwork(String url) {
    return new LoginNetworking(url);
  }

  @Provides String provideLoginUrl() {
    if (MyApplication.DEBUG) {
      return "http://192.168.1.99:9080/mfp/";
    } else {
      return "http://211.219.71.228:9080/mfp/";
    }
  }
  @Provides LoginCommunicationListener provideLoginCommunicationListener(LoginFragment loginFragment) {
    return loginFragment.loginCommunicationListener;
  }
  @Provides LoginFragmentPresenter provideLoginPresenter(LoginFragmentPresenter.View view, LoginNetworking networking, LoginCommunicationListener loginListener) {
    return new LoginFragmentPresenterImpl(view, networking, loginListener);
  }
}