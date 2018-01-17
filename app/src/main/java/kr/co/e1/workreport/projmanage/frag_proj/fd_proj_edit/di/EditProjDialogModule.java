package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.EditProjDialog;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.EditProjDialogPresenter;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.EditProjDialogPresenterImpl;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.network.EditProjNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class EditProjDialogModule {

  @Provides EditProjDialogPresenter.View provideEditProjDialogView(EditProjDialog fragment) {
    return fragment;
  }

  @Provides EditProjDialogPresenter provideEditProjDialogPresenter(EditProjDialog fragment,
      EditProjNetwork network) {
    return new EditProjDialogPresenterImpl(fragment, network);
  }

  @Provides EditProjNetwork provideEditProjNetwork() {
    return new EditProjNetwork(Constants.BASE_URL);
  }
}