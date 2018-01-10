package kr.co.e1.workreport.main.dg_pass;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Subcomponent(modules = PasswordDialogModule.class)
public interface PasswordDialogComponent extends AndroidInjector<PasswordDialog> {

  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<PasswordDialog> {

  }
}