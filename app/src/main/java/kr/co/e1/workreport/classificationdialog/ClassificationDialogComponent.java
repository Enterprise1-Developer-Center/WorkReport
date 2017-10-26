package kr.co.e1.workreport.classificationdialog;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Subcomponent(modules = ClassificationDialogModule.class)
public interface ClassificationDialogComponent extends AndroidInjector<ClassificationDialog> {

  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<ClassificationDialog> {

  }
}