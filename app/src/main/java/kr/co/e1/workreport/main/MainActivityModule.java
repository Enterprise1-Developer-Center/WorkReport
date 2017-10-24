package kr.co.e1.workreport.main;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.classification.ClassificationComponent;
import kr.co.e1.workreport.login.LoginFragmentComponent;
import kr.co.e1.workreport.report.ReportFragmentComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { LoginFragmentComponent.class, ReportFragmentComponent.class,
    ClassificationComponent.class
})
public class MainActivityModule {

  @Provides MainPresenter.View provideMainView(MainActivity mainActivity) {
    return mainActivity;
  }

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view) {
    return new MainPresenterImpl(view);
  }
}