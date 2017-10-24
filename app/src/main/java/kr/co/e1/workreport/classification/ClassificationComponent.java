package kr.co.e1.workreport.classification;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 24
 */

@Subcomponent(modules = ClassificationModule.class) public interface ClassificationComponent
    extends AndroidInjector<ClassificationDialogFragment> {

  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<ClassificationDialogFragment> {

  }
}
