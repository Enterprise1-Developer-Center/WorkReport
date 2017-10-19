package kr.co.e1.workreport.report;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by jaeho on 2017. 10. 19
 */

@Subcomponent(modules = ReportFragmentModule.class) public interface ReportFragmentComponent
    extends AndroidInjector<ReportFragment> {

  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<ReportFragment> {

  }
}