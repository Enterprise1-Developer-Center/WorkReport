package kr.co.e1.workreport.main.dg_login.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.main.dg_login.LoginFragment;
import kr.co.e1.workreport.main.dg_login.LoginFragmentPresenter;
import kr.co.e1.workreport.main.dg_login.LoginFragmentPresenterImpl;
import kr.co.e1.workreport.main.dg_login.network.LoginNetwork;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public class LoginFragmentModule {
  @Provides LoginFragmentPresenter.View provideLoginView(LoginFragment loginFragment) {
    return loginFragment;
  }

  @Singleton @Provides LoginNetwork provideNetworkHelper() {
    return new LoginNetwork(MyApplication.BASE_URL);
  }

  @Singleton @Provides LoginFragmentPresenter provideLoginPresenter(LoginFragment fragment,
      LoginNetwork network) {
    return new LoginFragmentPresenterImpl(fragment, network,
        fragment.getLoginCommunicationListener());
  }
}