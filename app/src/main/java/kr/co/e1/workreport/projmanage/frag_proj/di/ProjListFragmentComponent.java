package kr.co.e1.workreport.projmanage.frag_proj.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { ProjListFragmentModule.class }) public interface ProjListFragmentComponent
    extends AndroidInjector<ProjListFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<ProjListFragment> {
  }
}
