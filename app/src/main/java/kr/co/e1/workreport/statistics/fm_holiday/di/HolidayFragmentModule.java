package kr.co.e1.workreport.statistics.fm_holiday.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;
import kr.co.e1.workreport.statistics.fm_holiday.HolidayFragment;
import kr.co.e1.workreport.statistics.fm_holiday.HolidayFragmentPresenter;
import kr.co.e1.workreport.statistics.fm_holiday.HolidayFragmentPresenterImpl;
import kr.co.e1.workreport.statistics.fm_holiday.adapter.HolidayAdapter;
import kr.co.e1.workreport.statistics.fm_holiday.adapter.HolidayAdapterView;
import kr.co.e1.workreport.statistics.fm_holiday.network.HolidayNetwork;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Module public class HolidayFragmentModule {

  @Provides HolidayFragmentPresenter.View provideHolidayFragmentView(HolidayFragment fragment) {
    return fragment;
  }

  @Provides HolidayFragmentPresenter provideHolidayFragmentPresenter(HolidayFragment fragment,
      HolidayNetwork network) {
    return new HolidayFragmentPresenterImpl(fragment, network, fragment.getAdapter());
  }

  @Provides HolidayAdapter provideHolidayAdapter(HolidayFragment fragment) {
    return new HolidayAdapter().setOnRecyclerItemClickListener(fragment);
  }

  @Provides HolidayNetwork provideHolidayNetwork() {
    return new HolidayNetwork(MyApplication.BASE_URL);
  }

  @Provides HolidayAdapterView provideAdapterView(HolidayFragment fragment) {
    return fragment.getAdapter();
  }
}