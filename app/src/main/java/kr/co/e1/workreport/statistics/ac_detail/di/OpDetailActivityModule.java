package kr.co.e1.workreport.statistics.ac_detail.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.statistics.ac_detail.OpDetailActivity;
import kr.co.e1.workreport.statistics.ac_detail.OpDetailPresenter;
import kr.co.e1.workreport.statistics.ac_detail.OpDetailPresenterImpl;
import kr.co.e1.workreport.statistics.ac_detail.adapter.OpDetailAdapter;
import kr.co.e1.workreport.statistics.ac_detail.adapter.OpDetailAdapterView;
import kr.co.e1.workreport.statistics.ac_detail.network.OpDetailNetwork;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public class OpDetailActivityModule {

  @Provides OpDetailPresenter provideOpDetailPresenter(OpDetailActivity activity,
      OpDetailAdapter adapter, OpDetailNetwork network) {
    return new OpDetailPresenterImpl(activity, adapter, network);
  }

  @Singleton @Provides OpDetailAdapter provideOpDetailAdapter() {
    return new OpDetailAdapter();
  }

  @Provides OpDetailAdapterView provideAdapterView(OpDetailAdapter adapter) {
    return adapter;
  }

  @Provides @Singleton OpDetailNetwork provideOpDetailNetwork() {
    return new OpDetailNetwork(MyApplication.BASE_URL);
  }
}