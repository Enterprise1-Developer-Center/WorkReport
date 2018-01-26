package kr.co.e1.workreport.statistics.fm_holiday.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.statistics.fm_holiday.HolidayFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public abstract class HolidayFragmentProvider {

  @Binds @IntoMap @FragmentKey(HolidayFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideHolidayFragmentFactory(
      HolidayFragmentComponent.Builder builder);
}