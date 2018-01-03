package kr.co.e1.workreport.main.dialog_proje;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public abstract class ProjectDialogProvider {

  @Binds @IntoMap @FragmentKey(ProjectDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideProjectDialogFactory(
      ProjectDialogComponent.Builder builder);
}
