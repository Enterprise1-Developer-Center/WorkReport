package kr.co.e1.workreport.project;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Subcomponent(modules = ProjectDialogModule.class)
public interface ProjectDialogComponent extends AndroidInjector<ProjectDialog> {

  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<ProjectDialog> {

  }
}