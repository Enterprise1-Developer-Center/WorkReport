package kr.co.e1.workreport.main.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.main.MainActivity;
import kr.co.e1.workreport.main.MainPresenter;
import kr.co.e1.workreport.main.MainPresenterImpl;
import kr.co.e1.workreport.main.adapter.MainAdapterView;
import kr.co.e1.workreport.main.adapter.MainReportAdapter;
import kr.co.e1.workreport.main.dg_class.ClassificationDialogComponent;
import kr.co.e1.workreport.main.dg_login.LoginFragmentComponent;
import kr.co.e1.workreport.main.dg_pass.PasswordDialogComponent;
import kr.co.e1.workreport.main.dg_proje.ProjectDialogComponent;
import kr.co.e1.workreport.main.network.MainNetwork;

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

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view, MainActivity activity,
      MainNetwork network) {
    return new MainPresenterImpl(view, activity.getAdapter(), network);
  }

  @Provides MainReportAdapter provideReportAdapter(MainActivity activity) {
    return new MainReportAdapter(activity, activity);
  }

  @Provides MainAdapterView provideBaseAdapterView(MainActivity activity) {
    return activity.getAdapter();
  }

  @Provides MainNetwork provideMainNetwork() {
    return new MainNetwork(MyApplication.BASE_URL);
  }
}