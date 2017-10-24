package kr.co.e1.workreport.di;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import kr.co.e1.workreport.classificationcode.ClassificationCodeActivity;
import kr.co.e1.workreport.classificationcode.ClassificationCodeComponent;
import kr.co.e1.workreport.main.MainActivity;
import kr.co.e1.workreport.main.MainActivityComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module public abstract class ActivityBuilder {

  @Binds @IntoMap @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(
      MainActivityComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(ClassificationCodeActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindClassificatoinCodeActivity(
      ClassificationCodeComponent.Builder builder);
}
