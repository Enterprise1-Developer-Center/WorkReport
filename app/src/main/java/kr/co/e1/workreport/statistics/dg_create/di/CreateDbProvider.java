package kr.co.e1.workreport.statistics.dg_create.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.statistics.dg_create.CreateDbFragment;

/**
 * Created by jaeho on 2018. 1. 3
 */

@Module public abstract class CreateDbProvider {
  @Binds @IntoMap @FragmentKey(CreateDbFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideCreateDbFragmentFactory(
      CreateDbComponent.Builder builder);
}