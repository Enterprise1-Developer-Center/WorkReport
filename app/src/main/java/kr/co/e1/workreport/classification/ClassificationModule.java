package kr.co.e1.workreport.classification;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jaeho on 2017. 10. 24
 */

@Module public class ClassificationModule {

  @Provides ClassificationPresenter.View getClassificationView(
      ClassificationDialogFragment fragment) {
    return fragment;
  }

  @Provides ClassificationPresenter getClassificationPresenter(ClassificationPresenter.View view) {
    return new ClassificationPresenterImpl(view);
  }
}