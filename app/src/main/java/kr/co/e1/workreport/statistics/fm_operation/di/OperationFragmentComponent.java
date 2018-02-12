package kr.co.e1.workreport.statistics.fm_operation.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import javax.inject.Singleton;
import kr.co.e1.workreport.statistics.fm_operation.OperationFragment;

/**
 * Created by jaeho on 2017. 11. 2
 */

@Singleton @Subcomponent (modules = { OperationFragmentModule.class })
public interface OperationFragmentComponent extends AndroidInjector<OperationFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<OperationFragment> {
  }
}
