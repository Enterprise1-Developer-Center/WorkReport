package kr.co.e1.workreport.statistics.di;

import android.widget.ArrayAdapter;
import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.statistics.StatisticsActivity;
import kr.co.e1.workreport.statistics.StatisticsPresenter;
import kr.co.e1.workreport.statistics.StatisticsPresenterImpl;
import kr.co.e1.workreport.statistics.dg_create.di.CreateDbComponent;
import kr.co.e1.workreport.statistics.fm_operation.di.OperationFragmentComponent;
import kr.co.e1.workreport.statistics.fm_total.di.TotalFragmentComponent;
import kr.co.e1.workreport.statistics.network.StatisticsNetwork;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    OperationFragmentComponent.class, TotalFragmentComponent.class, CreateDbComponent.class
}) public class StatisticsActivityModule {

  @Provides StatisticsPresenter.View provideStatisticsView(StatisticsActivity statisticsActivity) {
    return statisticsActivity;
  }

  @Provides StatisticsPresenter provideStatisticsPresenter(StatisticsPresenter.View view,
      StatisticsNetwork network) {
    return new StatisticsPresenterImpl(view, network);
  }

  @Provides ArrayAdapter<String> provideSpinnerAdapter(StatisticsActivity activity) {
    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(activity.getApplicationContext(), R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    return adapter;
  }

  @Provides StatisticsNetwork provideStatisticsNetwork() {
    return new StatisticsNetwork(MyApplication.BASE_URL);
  }
}