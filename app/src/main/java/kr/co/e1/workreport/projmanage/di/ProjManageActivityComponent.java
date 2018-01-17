package kr.co.e1.workreport.projmanage.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.ProjManageActivity;
import kr.co.e1.workreport.projmanage.frag_emp.di.EmpListFragmentProvider;
import kr.co.e1.workreport.projmanage.frag_proj.di.ProjListFragmentProvider;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.di.AddProjDialogProvider;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.di.EditProjDialogProvider;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    ProjManageActivityModule.class, ProjListFragmentProvider.class, EmpListFragmentProvider.class,
    AddProjDialogProvider.class, EditProjDialogProvider.class
}) public interface ProjManageActivityComponent extends AndroidInjector<ProjManageActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<ProjManageActivity> {

  }
}