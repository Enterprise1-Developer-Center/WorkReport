package kr.co.e1.workreport.classificationdialog;

import dagger.Module;
import dagger.Provides;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.classificationdialog.adapter.ClassificationDialogAdapter;
import kr.co.e1.workreport.classificationdialog.adapter.ClassificationSelectableItem;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class ClassificationDialogModule {

  @DebugLog public ClassificationDialogModule() {
  }

  @Provides ClassificationDialogPresenter.View provideClassificationDialogView(
      ClassificationDialog dialog) {
    return dialog;
  }

  @Provides OnRecyclerItemClickListener<ClassificationSelectableItem> provideOnRecyclerItemClickListener(
      ClassificationDialog dialog) {
    return dialog;
  }

  @Provides ClassificationDialogAdapter provideClassificationDialogAdapter(
      OnRecyclerItemClickListener<ClassificationSelectableItem> listener) {
    return new ClassificationDialogAdapter(listener);
  }

  @Provides ClassificationDialogPresenter provideClassificationDialogPresenter(
      ClassificationDialogPresenter.View view) {
    return new ClassificationDialogPresenterImpl(view);
  }
}