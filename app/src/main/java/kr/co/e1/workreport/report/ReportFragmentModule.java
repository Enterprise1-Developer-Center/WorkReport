package kr.co.e1.workreport.report;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class ReportFragmentModule {

  @Provides ReportFragmentPresenter.View provideReportView(ReportFragment reportFragment) {
    return reportFragment;
  }

  @Provides ReportFragmentPresenter provideReportPresenter(ReportFragmentPresenter.View view) {
    return new ReportFragmentPresenterImpl(view);
  }
}