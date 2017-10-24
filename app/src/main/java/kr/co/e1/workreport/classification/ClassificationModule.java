package kr.co.e1.workreport.classification;

import dagger.Module;
import dagger.Provides;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.classification.adapter.ClassificationAdapter;

/**
 * Created by jaeho on 2017. 10. 24
 */

@Module public class ClassificationModule {

  @Provides ClassificationPresenter.View provideClassificationView(
      ClassificationDialogFragment fragment) {
    return fragment;
  }

  @Provides ClassificationPresenter provideClassificationPresenter(
      ClassificationPresenter.View view, ClassificationAdapter adapter) {
    return new ClassificationPresenterImpl(view, adapter);
  }

  @DebugLog @Provides ClassificationAdapter provideClassificationAdapter() {
    return ClassificationAdapter.getInstance();
  }
}