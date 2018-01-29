package kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.EditHolidayDialog;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent(modules = {EditHolidayDialogModule.class }) public interface EditHolidayDialogComponent
    extends AndroidInjector<EditHolidayDialog> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<EditHolidayDialog> {
  }
}
