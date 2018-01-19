package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.AddEmpDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class AddEmpDialogProvider {

  @Binds @IntoMap @FragmentKey(AddEmpDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideAddProjDialogFactory(
      AddEmpDialogComponent.Builder builder);
}