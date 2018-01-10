package kr.co.e1.workreport.main.dg_class;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public abstract class ClassificationDialogProvider {

  @Binds @IntoMap @FragmentKey(ClassificationDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideClassificationDialogFactory(
      ClassificationDialogComponent.Builder builder);
}
