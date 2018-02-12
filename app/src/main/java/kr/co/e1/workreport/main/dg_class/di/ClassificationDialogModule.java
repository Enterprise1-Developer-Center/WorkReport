package kr.co.e1.workreport.main.dg_class.di;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.app.MyApplication;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.main.dg_class.ClassificationDialog;
import kr.co.e1.workreport.main.dg_class.ClassificationDialogPresenter;
import kr.co.e1.workreport.main.dg_class.ClassificationDialogPresenterImpl;
import kr.co.e1.workreport.main.dg_class.adapter.ClassificationDialogAdapter;
import kr.co.e1.workreport.main.dg_class.network.ClassificationNetwork;

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
    return new ClassificationDialogAdapter(dialog.getNowDetailWork());
  }

  @Provides ClassificationDialogPresenter provideClassificationDialogPresenter(
      ClassificationDialogPresenter.View view, ClassificationDialog dialog,
      ClassificationNetwork network) {
    return new ClassificationDialogPresenterImpl(view, dialog.getAdapter(), network);
  }

  @Provides ClassificationNetwork provideNetwork() {
    return new ClassificationNetwork(MyApplication.BASE_URL);
  }

  @Provides BaseAdapterView provideClassificationDialogAdapterView(ClassificationDialog dialog) {
    return dialog.getAdapter();
  }
}