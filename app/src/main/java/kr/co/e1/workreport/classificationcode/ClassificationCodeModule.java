package kr.co.e1.workreport.classificationcode;

import dagger.Module;
import dagger.Provides;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.classificationcode.adapter.ClassificationAdapter;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;

/**
 * Created by jaeho on 2017. 10. 24
 */

@Module public class ClassificationCodeModule {

  @Provides ClassificationCodePresenter.View provideClassificationView(
      ClassificationCodeActivity activity) {
    return activity;
  }

  @Provides ClassificationCodePresenter provideClassificationPresenter(
      ClassificationCodePresenter.View view, ClassificationAdapter adapter) {
    return new ClassificationCodePresenterImpl(view, adapter);
  }

  @DebugLog @Provides ClassificationAdapter provideClassificationAdapter(
      ClassificationCodeActivity activity) {
    return ClassificationAdapter.getInstance(activity);
  }

  @DebugLog @Provides BaseAdapterView provideBaseAdapterView(ClassificationCodeActivity activity) {
    return ClassificationAdapter.getInstance(activity);
  }
}