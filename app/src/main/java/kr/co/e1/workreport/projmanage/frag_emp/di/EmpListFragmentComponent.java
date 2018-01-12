package kr.co.e1.workreport.projmanage.frag_emp.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { EmpListFragmentModule.class }) public interface EmpListFragmentComponent
    extends AndroidInjector<EmpListFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<EmpListFragment> {
  }
}
