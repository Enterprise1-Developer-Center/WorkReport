package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.AddEmpDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { AddEmpDialogModule.class }) public interface AddEmpDialogComponent
    extends AndroidInjector<AddEmpDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<AddEmpDialog> {
  }
}
