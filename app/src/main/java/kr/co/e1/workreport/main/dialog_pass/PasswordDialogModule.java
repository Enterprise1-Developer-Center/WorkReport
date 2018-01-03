package kr.co.e1.workreport.main.dialog_pass;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class PasswordDialogModule {

  @Provides PasswordDialogPresenter.View providePasswordDialogView(PasswordDialog dialog) {
    return dialog;
  }

  @Provides PasswordDialogPresenter providePasswordDialogPresenter(
      PasswordDialogPresenter.View view, PasswordNetwork network) {
    return new PasswordDialogPresenterImpl(view, network);
  }

  @Provides PasswordNetwork providePasswordNetwork() {
    return new PasswordNetwork(Constants.BASE_URL);
  }
}