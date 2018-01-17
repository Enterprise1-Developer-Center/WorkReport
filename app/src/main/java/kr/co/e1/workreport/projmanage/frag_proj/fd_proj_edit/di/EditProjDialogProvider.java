package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_edit.EditProjDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class EditProjDialogProvider {

  @Binds @IntoMap @FragmentKey(EditProjDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideEditProjDialogFactory(
      EditProjDialogComponent.Builder builder);
}