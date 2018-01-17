package kr.co.e1.workreport.projmanage.frag_proj.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragmentPresenter;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragmentPresenterImpl;
import kr.co.e1.workreport.projmanage.frag_proj.adapter.ProjListAdapter;
import kr.co.e1.workreport.projmanage.frag_proj.adapter.ProjListAdapterView;
import kr.co.e1.workreport.projmanage.frag_proj.network.ProjListNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class ProjListFragmentModule {

  @Provides ProjListFragmentPresenter.View provideProjListFragmentView(ProjListFragment fragment) {
    return fragment;
  }

  @Provides ProjListFragmentPresenter provideProjListFragmentPresenter(ProjListFragment fragment,
      ProjListNetwork network) {
    return new ProjListFragmentPresenterImpl(fragment, network, fragment.getAdapter());
  }

  @Provides ProjListAdapter provideProjListAdapter(ProjListFragment fragment) {
    return new ProjListAdapter().setOnRecyclerItemClickListener(fragment);
  }

  @Provides ProjListNetwork provideProjListNetwork() {
    return new ProjListNetwork(MyApplication.BASE_URL);
  }

  @Provides ProjListAdapterView provideAdapterView(ProjListFragment fragment) {
    return fragment.getAdapter();
  }
}