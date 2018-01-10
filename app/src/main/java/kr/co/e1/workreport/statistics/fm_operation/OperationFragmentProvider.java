package kr.co.e1.workreport.statistics.fm_operation;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class OperationFragmentProvider {

  @Binds @IntoMap @FragmentKey(OperationFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideOperationFragmentFactory(
      OperationFragmentComponent.Builder builder);
}
