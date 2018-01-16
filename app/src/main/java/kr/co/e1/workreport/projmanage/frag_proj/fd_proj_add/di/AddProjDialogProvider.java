package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.AddProjDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class AddProjDialogProvider {

  @Binds @IntoMap @FragmentKey(AddProjDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideAddProjDialogFactory(
      AddProjDialogComponent.Builder builder);
}