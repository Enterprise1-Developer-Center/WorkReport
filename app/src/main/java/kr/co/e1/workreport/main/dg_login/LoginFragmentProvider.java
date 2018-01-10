package kr.co.e1.workreport.main.dg_login;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 9. 27
 */

@Module public abstract class LoginFragmentProvider {

  @Binds @IntoMap @FragmentKey(LoginFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideLoginFragmentFactory(
      LoginFragmentComponent.Builder builder);
}