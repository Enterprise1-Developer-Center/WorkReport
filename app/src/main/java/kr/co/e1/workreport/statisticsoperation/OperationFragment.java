package kr.co.e1.workreport.statisticsoperation;

import android.os.Bundle;
import butterknife.BindView;
import com.github.mikephil.charting.charts.LineChart;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */
public class OperationFragment extends BaseFragment implements OperationFragmentPresenter.View {

  @BindView(R.id.chart) LineChart chart;
  @Inject OperationFragmentPresenter presenter;

  public static OperationFragment newInstance() {
    return new OperationFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_operation_ratio;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);
  }

  @Override protected boolean isDagger() {
    return true;
  }
}