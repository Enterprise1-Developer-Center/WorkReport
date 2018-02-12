package kr.co.e1.workreport.teamreport.dialog.di;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.teamreport.dialog.TeamReportDialog;

/**
 * Created by jaeho on 2018. 2. 12
 */

@Module public abstract class TeamReportDialogProvider {

  @Binds @IntoMap @FragmentKey(TeamReportDialog.class)
  abstract AndroidInjector.Factory<? extends Fragment> provideTeamReportDialogFactory(
      TeamReportDialogComponent.Builder builder);
}
