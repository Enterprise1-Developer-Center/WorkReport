package kr.co.e1.workreport.projmanage.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.projmanage.ProjManageActivity;
import kr.co.e1.workreport.projmanage.ProjManagePresenter;
import kr.co.e1.workreport.projmanage.ProjManagePresenterImpl;
import kr.co.e1.workreport.projmanage.frag_emp.di.EmpListFragmentComponent;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.di.AddEmpDialogComponent;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.di.EditEmpDialogComponent;
import kr.co.e1.workreport.projmanage.frag_proj.di.ProjListFragmentComponent;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.di.AddProjDialogComponent;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.di.EditProjDialogComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    ProjListFragmentComponent.class, EmpListFragmentComponent.class, AddProjDialogComponent.class,
    EditProjDialogComponent.class, AddEmpDialogComponent.class, EditEmpDialogComponent.class
}) public class ProjManageActivityModule {

  @Provides ProjManagePresenter provideProjManagePresenter(ProjManageActivity activity) {
    return new ProjManagePresenterImpl(activity);
  }
}