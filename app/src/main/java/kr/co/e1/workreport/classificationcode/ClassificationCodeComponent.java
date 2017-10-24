package kr.co.e1.workreport.classificationcode;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 24
 */

@Subcomponent(modules = ClassificationCodeModule.class)
public interface ClassificationCodeComponent
    extends AndroidInjector<ClassificationCodeActivity> {

  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<ClassificationCodeActivity> {

  }
}
