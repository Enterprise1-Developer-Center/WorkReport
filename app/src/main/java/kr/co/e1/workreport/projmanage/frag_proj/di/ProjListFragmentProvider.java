package kr.co.e1.workreport.projmanage.frag_proj.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class ProjListFragmentProvider {

  @Binds @IntoMap @FragmentKey(ProjListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideProjListFragmentFactory(
      ProjListFragmentComponent.Builder builder);
}