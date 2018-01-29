package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.AddHolidayDialog;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.AddHolidayDialogPresenter;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.AddHolidayDialogPresenterImpl;
import kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday.network.AddHolidayNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class AddHolidayDialogModule {

  @Provides AddHolidayDialogPresenter.View provideAddHolidayDialogView(AddHolidayDialog fragment) {
    return fragment;
  }

  @Provides AddHolidayDialogPresenter provideAddHolidayDialogPresenter(AddHolidayDialog fragment, AddHolidayNetwork network) {
    return new AddHolidayDialogPresenterImpl(fragment, network);
  }

  @Provides AddHolidayNetwork provideAddHolidayNetwork() {
    return new AddHolidayNetwork(Constants.BASE_URL);
  }
}