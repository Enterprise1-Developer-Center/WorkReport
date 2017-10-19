package kr.co.e1.workreport.report;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public abstract class ReportFragmentProvider {

  @Binds @IntoMap @FragmentKey(ReportFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideReportFragmentFactory(
      ReportFragmentComponent.Builder builder);
}
