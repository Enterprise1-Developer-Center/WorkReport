package kr.co.e1.workreport.projmanage.frag_emp.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class EmpListFragmentProvider {

  @Binds @IntoMap @FragmentKey(EmpListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideEmpListFragmentFactory(
      EmpListFragmentComponent.Builder builder);
}