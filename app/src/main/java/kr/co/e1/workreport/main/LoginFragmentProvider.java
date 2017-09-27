package kr.co.e1.workreport.main;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.login.LoginFragment;
import kr.co.e1.workreport.login.LoginFragmentComponent;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public abstract class LoginFragmentProvider {

  @Binds @IntoMap @FragmentKey(LoginFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideLoginFragmentFactory(
      LoginFragmentComponent.Builder builder);
}
