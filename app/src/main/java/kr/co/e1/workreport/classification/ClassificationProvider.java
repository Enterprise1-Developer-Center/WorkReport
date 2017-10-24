package kr.co.e1.workreport.classification;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 10. 24
 */

@Module public abstract class ClassificationProvider {

  @Binds @IntoMap @FragmentKey(ClassificationDialogFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideClassificationFactory(
      ClassificationComponent.Builder builder);
}
