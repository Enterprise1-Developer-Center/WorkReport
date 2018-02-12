package kr.co.e1.workreport.statistics.ac_detail.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import javax.inject.Singleton;
import kr.co.e1.workreport.statistics.ac_detail.OpDetailActivity;

/**
 * Created by jaeho on 2018. 2. 12..
 */

@Singleton @Subcomponent(modules = {
    OpDetailActivityModule.class
}) public interface OpDetailActivityComponent extends AndroidInjector<OpDetailActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<OpDetailActivity> {

  }
}
