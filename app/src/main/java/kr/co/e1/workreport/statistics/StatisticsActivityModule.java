package kr.co.e1.workreport.statistics;

import android.widget.ArrayAdapter;
import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.statistics.dialog_create.di.CreateDbComponent;
import kr.co.e1.workreport.statistics.fm_operatio.OperationFragmentComponent;
import kr.co.e1.workreport.statistics.fm_total.TotalFragmentComponent;

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
    return new StatisticsNetwork(Constants.BASE_URL);
  }
}