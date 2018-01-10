package kr.co.e1.workreport.statistics.ac_detail;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 9. 25
 */

@Subcomponent(modules = {
    OpDetailActivityModule.class
}) public interface OpDetailActivityComponent extends AndroidInjector<OpDetailActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<OpDetailActivity> {

  }
}