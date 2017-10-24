package kr.co.e1.workreport.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.classification.ClassificationProvider;
import kr.co.e1.workreport.login.LoginFragmentProvider;
import kr.co.e1.workreport.report.ReportFragmentProvider;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    MainActivityModule.class, LoginFragmentProvider.class, ReportFragmentProvider.class,
    ClassificationProvider.class
}) public interface MainActivityComponent extends AndroidInjector<MainActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<MainActivity> {

  }
}
