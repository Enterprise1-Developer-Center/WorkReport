package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.EditEmpDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class EditEmpDialogProvider {

  @Binds @IntoMap @FragmentKey(EditEmpDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideEditProjDialogFactory(
      EditEmpDialogComponent.Builder builder);
}