package kr.co.e1.workreport.project;

import android.os.Bundle;
import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.framework.adapter.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.adapter.ProjectDialogAdapter;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class ProjectDialogModule {

  @Provides ProjectDialogPresenter.View provideProjectDialogView(ProjectDialog dialog) {
    return dialog;
  }

  @Provides OnRecyclerItemClickListener<Bundle> provideOnRecyclerItemClickListener(
      ProjectDialog dialog) {
    return dialog;
  }

  @Provides ProjectDialogAdapter provideProjectDialogAdapter(ProjectDialog dialog) {
    return new ProjectDialogAdapter(dialog);
  }

  @Provides ProjectDialogPresenter provideProjectDialogPresenter(ProjectDialogPresenter.View view) {
    return new ProjectDialogPresenterImpl(view);
  }
}