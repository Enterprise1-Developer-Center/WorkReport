package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.AddProjDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { AddProjDialogModule.class }) public interface AddProjDialogComponent
    extends AndroidInjector<AddProjDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<AddProjDialog> {
  }
}
