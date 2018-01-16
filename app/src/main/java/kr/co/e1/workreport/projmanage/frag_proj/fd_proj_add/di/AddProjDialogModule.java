package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.AddProjDialog;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.AddProjDialogPresenter;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.AddProjDialogPresenterImpl;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class AddProjDialogModule {

  @Provides AddProjDialogPresenter.View provideAddProjDialogView(AddProjDialog fragment) {
    return fragment;
  }

  @Provides AddProjDialogPresenter provideAddProjDialogPresenter(AddProjDialog fragment) {
    return new AddProjDialogPresenterImpl(fragment);
  }
}