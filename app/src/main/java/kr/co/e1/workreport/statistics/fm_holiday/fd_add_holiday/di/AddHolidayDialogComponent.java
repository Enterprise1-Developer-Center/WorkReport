package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.AddHolidayDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = { AddHolidayDialogModule.class }) public interface AddHolidayDialogComponent
    extends AndroidInjector<AddHolidayDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<AddHolidayDialog> {
  }
}
