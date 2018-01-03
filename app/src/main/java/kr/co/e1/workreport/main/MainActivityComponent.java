package kr.co.e1.workreport.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.main.dialog_class.ClassificationDialogProvider;
import kr.co.e1.workreport.main.dialog_login.LoginFragmentProvider;
import kr.co.e1.workreport.main.dialog_pass.PasswordDialogProvider;
import kr.co.e1.workreport.main.dialog_proje.ProjectDialogProvider;

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
