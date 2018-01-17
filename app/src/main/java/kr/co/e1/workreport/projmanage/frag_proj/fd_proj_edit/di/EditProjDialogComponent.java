package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.EditProjDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { EditProjDialogModule.class }) public interface EditProjDialogComponent
    extends AndroidInjector<EditProjDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<EditProjDialog> {
  }
}
