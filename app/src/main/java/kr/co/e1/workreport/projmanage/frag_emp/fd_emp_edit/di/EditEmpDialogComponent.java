package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.EditEmpDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { EditEmpDialogModule.class }) public interface EditEmpDialogComponent
    extends AndroidInjector<EditEmpDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<EditEmpDialog> {
  }
}
