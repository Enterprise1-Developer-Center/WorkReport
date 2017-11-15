package kr.co.e1.workreport.classificationdialog;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.classificationdialog.adapter.ClassificationDialogAdapter;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class ClassificationDialogModule {

  @Provides ClassificationDialogPresenter.View provideClassificationDialogView(
      ClassificationDialog dialog) {
    return dialog;
  }
  
  @Provides ClassificationDialogAdapter provideClassificationDialogAdapter(
      ClassificationDialog dialog) {
    return new ClassificationDialogAdapter().setSelectedCode(dialog.selectedCode);
  }

  @Provides ClassificationDialogPresenter provideClassificationDialogPresenter(
      ClassificationDialogPresenter.View view, ClassificationDialog dialog,
      ClassificationNetwork network) {
    return new ClassificationDialogPresenterImpl(view, dialog.adapter, network);
  }

  @Provides ClassificationNetwork provideNetwork() {
    return new ClassificationNetwork(Constants.BASE_URL);
  }

  @Provides BaseAdapterView provideClassificationDialogAdapterView(ClassificationDialog dialog) {
    return dialog.adapter;
  }
}