package kr.co.e1.workreport.di;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.main.MainActivity;
import kr.co.e1.workreport.main.di.MainActivityComponent;
import kr.co.e1.workreport.projmanage.ProjManageActivity;
import kr.co.e1.workreport.projmanage.di.ProjManageActivityComponent;
import kr.co.e1.workreport.statistics.StatisticsActivity;
import kr.co.e1.workreport.statistics.ac_detail.OpDetailActivity;
import kr.co.e1.workreport.statistics.ac_detail.di.OpDetailActivityComponent;
import kr.co.e1.workreport.statistics.di.StatisticsActivityComponent;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import kr.co.e1.workreport.teamreport.di.TeamReportActivityComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public abstract class ActivityBuilder {

  @Binds @IntoMap @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(
      MainActivityComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(StatisticsActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindStatisticsActivityInjectorFactory(
      StatisticsActivityComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(ProjManageActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindProjManageActivityInjectorFactory(
      ProjManageActivityComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(OpDetailActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindOpDetailActivityInjectorFactory(
      OpDetailActivityComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(TeamReportActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindTeamReportActivityInjectorFactory(
      TeamReportActivityComponent.Builder builder);

}
