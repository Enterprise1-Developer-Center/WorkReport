package kr.co.e1.workreport.projmanage.frag_emp.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragmentPresenter;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragmentPresenterImpl;
import kr.co.e1.workreport.projmanage.frag_emp.adapter.EmpListAdapter;
import kr.co.e1.workreport.projmanage.frag_emp.adapter.EmpListAdapterView;
import kr.co.e1.workreport.projmanage.frag_emp.network.EmpListNetwork;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;
import kr.co.e1.workreport.projmanage.frag_proj.adapter.ProjListAdapter;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class EmpListFragmentModule {

  @Provides EmpListFragmentPresenter.View provideEmpListFragmentView(EmpListFragment fragment) {
    return fragment;
  }

  @Provides EmpListFragmentPresenter provideEmpListFragmentPresenter(EmpListFragment fragment, EmpListNetwork network) {
    return new EmpListFragmentPresenterImpl(fragment, network, fragment.getAdapter());
  }

  @Provides EmpListAdapter provideEmpListAdapter(EmpListFragment fragment) {
    return new EmpListAdapter().setOnRecyclerItemClickListener(fragment);
  }


  @Provides EmpListNetwork provideEmpListNetwork() {
    return new EmpListNetwork(Constants.BASE_URL);
  }

  @Provides EmpListAdapterView provideAdapterView(EmpListFragment fragment) {
    return fragment.getAdapter();
  }
}