package kr.co.e1.workreport.statistics;

import android.widget.ArrayAdapter;
import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.statisticsop.OperationFragmentComponent;
import kr.co.e1.workreport.statisticstotal.TotalFragmentComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    OperationFragmentComponent.class, TotalFragmentComponent.class
}) public class StatisticsActivityModule {

  @Provides StatisticsPresenter.View provideStatisticsView(StatisticsActivity statisticsActivity) {
    return statisticsActivity;
  }

  @Provides StatisticsPresenter provideStatisticsPresenter(StatisticsPresenter.View view) {
    return new StatisticsPresenterImpl(view);
  }

  @Provides ArrayAdapter<String> provideSpinnerAdapter(StatisticsActivity activity) {
    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(activity.getApplicationContext(), R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    return adapter;
  }
}