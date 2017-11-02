package kr.co.e1.workreport.statisticsoperation;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Subcomponent (modules = { OperationFragmentModule.class })
public interface OperationFragmentComponent extends AndroidInjector<OperationFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<OperationFragment> {
  }
}
