package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.AddEmpDialog;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.AddEmpDialogPresenter;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.AddEmpDialogPresenterImpl;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.network.AddEmpNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class AddEmpDialogModule {

  @Provides AddEmpDialogPresenter.View provideAddEmpDialogView(AddEmpDialog fragment) {
    return fragment;
  }

  @Provides AddEmpDialogPresenter provideAddEmpDialogPresenter(AddEmpDialog fragment, AddEmpNetwork network) {
    return new AddEmpDialogPresenterImpl(fragment, network);
  }

  @Provides AddEmpNetwork provideAddEmpNetwork() {
    return new AddEmpNetwork(Constants.BASE_URL);
  }
}