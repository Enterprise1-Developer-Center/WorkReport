package kr.co.e1.workreport.main;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.classificationdialog.ClassificationDialogComponent;
import kr.co.e1.workreport.login.LoginFragmentComponent;
import kr.co.e1.workreport.project.ProjectDialogComponent;
import kr.co.e1.workreport.report.ReportFragmentComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = {
    LoginFragmentComponent.class, ReportFragmentComponent.class,
    ClassificationDialogComponent.class, ProjectDialogComponent.class
}) public class MainActivityModule {

  @Provides MainPresenter.View provideMainView(MainActivity mainActivity) {
    return mainActivity;
  }

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view) {
    return new MainPresenterImpl(view);
  }
}