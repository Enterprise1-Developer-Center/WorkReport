package kr.co.e1.workreport.main;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.classificationdialog.ClassificationDialogComponent;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.main.adapter.MainReportAdapter;
import kr.co.e1.workreport.common.adapter.ReportAdapterView;
import kr.co.e1.workreport.login.LoginFragmentComponent;
import kr.co.e1.workreport.password.PasswordDialogComponent;
import kr.co.e1.workreport.project.ProjectDialogComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    LoginFragmentComponent.class, ClassificationDialogComponent.class, ProjectDialogComponent.class,
    PasswordDialogComponent.class
}) public class MainActivityModule {

  @Provides MainPresenter.View provideMainView(MainActivity mainActivity) {
    return mainActivity;
  }

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view, MainActivity activity, MainNetwork network) {
    return new MainPresenterImpl(view, activity.adapter, network);
  }

  @Provides MainReportAdapter provideReportAdapter(MainActivity activity) {
    return new MainReportAdapter(activity, activity);
  }

  @Provides ReportAdapterView provideBaseAdapterView(MainActivity activity) {
    return activity.adapter;
  }

  @Provides MainNetwork provideMainNetwork() {
    return new MainNetwork(Constants.BASE_URL);
  }
}