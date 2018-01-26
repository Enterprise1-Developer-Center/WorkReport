package kr.co.e1.workreport.statistics.fm_holiday.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.fm_holiday.HolidayFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { HolidayFragmentModule.class }) public interface HolidayFragmentComponent
    extends AndroidInjector<HolidayFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<HolidayFragment> {
  }
}
