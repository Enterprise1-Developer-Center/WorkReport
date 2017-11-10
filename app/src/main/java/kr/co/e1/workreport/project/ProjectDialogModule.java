package kr.co.e1.workreport.project;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.framework.adapter.BaseAdapterView;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.project.adapter.ProjectDialogAdapter;
import kr.co.e1.workreport.project.adapter.ProjectSelectableItem;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Module public class ProjectDialogModule {

  @Provides ProjectDialogPresenter.View provideProjectDialogView(ProjectDialog dialog) {
    return dialog;
  }

  @Provides OnRecyclerItemClickListener<ProjectSelectableItem> provideOnRecyclerItemClickListener(
      ProjectDialog dialog) {
    return dialog;
  }

  @Provides ProjectDialogAdapter provideProjectDialogAdapter(ProjectDialog dialog) {
    return new ProjectDialogAdapter(dialog);
  }

  @Provides ProjectDialogPresenter provideProjectDialogPresenter(ProjectDialogPresenter.View view,
      ProjectDialog dialog) {
    return new ProjectDialogPresenterImpl(view, dialog.adapter);
  }

  @Provides BaseAdapterView provideProjectDialogAdapterView(ProjectDialog dialog) {
    return dialog.adapter;
  }
}