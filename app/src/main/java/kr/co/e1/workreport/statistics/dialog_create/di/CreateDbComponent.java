package kr.co.e1.workreport.statistics.dialog_create.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kr.co.e1.workreport.statistics.dialog_create.CreateDbFragment;

/**
 * Created by jaeho on 2018. 1. 3
 */
@Subcomponent(modules = CreateDbModule.class) public interface CreateDbComponent
    extends AndroidInjector<CreateDbFragment> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<CreateDbFragment> {
  }
}
