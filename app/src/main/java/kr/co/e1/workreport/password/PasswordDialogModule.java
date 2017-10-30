package kr.co.e1.workreport.password;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class PasswordDialogModule {

  @Provides PasswordDialogPresenter.View providePasswordDialogView(PasswordDialog dialog) {
    return dialog;
  }

  @Provides PasswordDialogPresenter providePasswordDialogPresenter(PasswordDialogPresenter.View view) {
    return new PasswordDialogPresenterImpl(view);
  }
}