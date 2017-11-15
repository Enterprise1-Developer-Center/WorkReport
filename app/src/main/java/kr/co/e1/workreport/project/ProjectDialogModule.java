package kr.co.e1.workreport.project;

import dagger.Module;
import dagger.Provides;
import kr.co.e1.workreport.common.Constants;
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

  @Provides ProjectDialogAdapter provideProjectDialogAdapter(ProjectDialog dialog) {
    return new ProjectDialogAdapter().setSelectedCode(dialog.selectedCode);
  }

  @Provides ProjectDialogPresenter provideProjectDialogPresenter(ProjectDialogPresenter.View view,
      ProjectDialog dialog, ProjectNetwork network) {
    return new ProjectDialogPresenterImpl(view, dialog.adapter, network);
  }

  @Provides BaseAdapterView provideProjectDialogAdapterView(ProjectDialog dialog) {
    return dialog.adapter;
  }

  @Provides ProjectNetwork provideProjectNetwork() {
    return new ProjectNetwork(Constants.BASE_URL);
  }
}