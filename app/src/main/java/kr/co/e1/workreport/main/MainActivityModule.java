package kr.co.e1.workreport.main;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.main.dg_class.ClassificationDialogComponent;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.main.dg_login.LoginFragmentComponent;
import kr.co.e1.workreport.main.adapter.MainAdapterView;
import kr.co.e1.workreport.main.adapter.MainReportAdapter;
import kr.co.e1.workreport.main.dg_pass.PasswordDialogComponent;
import kr.co.e1.workreport.main.dg_proje.ProjectDialogComponent;

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

  @Provides MainAdapterView provideBaseAdapterView(MainActivity activity) {
    return activity.adapter;
  }

  @Provides MainNetwork provideMainNetwork() {
    return new MainNetwork(Constants.BASE_URL);
  }
}