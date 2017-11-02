package kr.co.e1.workreport.statisticstotal;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class TotalFragmentProvider {

  @Binds @IntoMap @FragmentKey(TotalFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideTotalFragmentFactory(
      TotalFragmentComponent.Builder builder);
}
