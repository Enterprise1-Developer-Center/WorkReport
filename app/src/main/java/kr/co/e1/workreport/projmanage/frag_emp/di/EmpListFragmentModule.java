package kr.co.e1.workreport.projmanage.frag_emp.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragmentPresenter;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragmentPresenterImpl;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class EmpListFragmentModule {

  @Provides EmpListFragmentPresenter.View provideEmpListFragmentView(EmpListFragment fragment) {
    return fragment;
  }

  @Provides EmpListFragmentPresenter provideEmpListFragmentPresenter(EmpListFragment fragment) {
    return new EmpListFragmentPresenterImpl(fragment);
  }
}