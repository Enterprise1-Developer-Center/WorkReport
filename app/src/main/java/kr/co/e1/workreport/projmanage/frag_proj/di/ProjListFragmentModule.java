package kr.co.e1.workreport.projmanage.frag_proj.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragmentPresenter;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragmentPresenterImpl;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class ProjListFragmentModule {

  @Provides ProjListFragmentPresenter.View provideProjListFragmentView(ProjListFragment fragment) {
    return fragment;
  }

  @Provides ProjListFragmentPresenter provideProjListFragmentPresenter(ProjListFragment fragment) {
    return new ProjListFragmentPresenterImpl(fragment);
  }
}