package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.EditEmpDialog;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.EditEmpDialogPresenter;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.EditEmpDialogPresenterImpl;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.network.EditEmpNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class EditEmpDialogModule {

  @Provides EditEmpDialogPresenter.View provideEditEmpDialogView(EditEmpDialog fragment) {
    return fragment;
  }

  @Provides EditEmpDialogPresenter provideEditEmpDialogPresenter(EditEmpDialog fragment, EditEmpNetwork network) {
    return new EditEmpDialogPresenterImpl(fragment, network);
  }

  @Provides EditEmpNetwork provideAddEmpNetwork() {
    return new EditEmpNetwork(Constants.BASE_URL);
  }
}