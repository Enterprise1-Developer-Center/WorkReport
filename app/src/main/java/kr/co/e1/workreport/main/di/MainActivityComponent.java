package kr.co.e1.workreport.main.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.main.MainActivity;
import kr.co.e1.workreport.main.dg_class.ClassificationDialogProvider;
import kr.co.e1.workreport.main.dg_login.di.LoginFragmentProvider;
import kr.co.e1.workreport.main.dg_pass.PasswordDialogProvider;
import kr.co.e1.workreport.main.dg_proje.ProjectDialogProvider;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    MainActivityModule.class, LoginFragmentProvider.class, ClassificationDialogProvider.class,
    ProjectDialogProvider.class, PasswordDialogProvider.class
}) public interface MainActivityComponent extends AndroidInjector<MainActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<MainActivity> {

  }
}
