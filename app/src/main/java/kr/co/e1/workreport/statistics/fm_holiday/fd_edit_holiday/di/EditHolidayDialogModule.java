package kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.EditHolidayDialog;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.EditHolidayDialogPresenter;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.EditHolidayDialogPresenterImpl;
import kr.co.e1.workreport.statistics.fm_holiday.fd_edit_holiday.network.EditHolidayNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class EditHolidayDialogModule {

  @Provides EditHolidayDialogPresenter.View provideEditHolidayDialogView(EditHolidayDialog fragment) {
    return fragment;
  }


  @Provides EditHolidayDialogPresenter provideEditHolidayDialogPresenter(EditHolidayDialog fragment, EditHolidayNetwork network) {
    return new EditHolidayDialogPresenterImpl(fragment, network);
  }

  @Provides EditHolidayNetwork provideEditHolidayNetwork() {
    return new EditHolidayNetwork(Constants.BASE_URL);
  }
}