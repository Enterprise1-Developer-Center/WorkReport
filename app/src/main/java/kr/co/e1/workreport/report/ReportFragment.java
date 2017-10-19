package kr.co.e1.workreport.report;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.OnClick;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 16
 */

public class ReportFragment extends BaseFragment implements ReportFragmentPresenter.View {

  @Inject ReportFragmentPresenter presenter;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_report;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    //presenter.onActivityCreate(savedInstanceState);
    Timber.d("presenter = " + presenter);
  }

  public static Fragment newInstance(Bundle args) {
    ReportFragment f = new ReportFragment();
    f.setArguments(args);
    return f;
  }

  @OnClick({
      R.id.date_rootview, R.id.group_rootview, R.id.person_rootview, R.id.start_time_rootview,
      R.id.end_time_rootview, R.id.code_rootview, R.id.project_rootview, R.id.last_edit_rootview
  }) void onClick(View view) {
    if (view.getId() == R.id.date_rootview) {
    } else if (view.getId() == R.id.group_rootview) {
    } else if (view.getId() == R.id.person_rootview) {
    }
  }
}
