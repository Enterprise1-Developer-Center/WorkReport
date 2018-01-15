package kr.co.e1.workreport.projmanage.di;

import android.support.v4.app.Fragment;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.projmanage.ProjManageActivity;
import kr.co.e1.workreport.projmanage.ProjManageAdapter;
import kr.co.e1.workreport.projmanage.ProjManagePresenter;
import kr.co.e1.workreport.projmanage.ProjManagePresenterImpl;
import kr.co.e1.workreport.projmanage.frag_emp.EmpListFragment;
import kr.co.e1.workreport.projmanage.frag_emp.di.EmpListFragmentComponent;
import kr.co.e1.workreport.projmanage.frag_proj.ProjListFragment;
import kr.co.e1.workreport.projmanage.frag_proj.di.ProjListFragmentComponent;

/**
 * Created by jaeho on 2017. 9. 25
 */
@Module(subcomponents = { ProjListFragmentComponent.class, EmpListFragmentComponent.class })
public class ProjManageActivityModule {

  @Provides ProjManageAdapter provideProjManageAdapter(ProjManageActivity activity) {
    List<Fragment> items = new ArrayList<>();
    items.add(ProjListFragment.newInstance());
    items.add(EmpListFragment.newInstance());
    return new ProjManageAdapter(activity.getSupportFragmentManager(), items);
  }

  @Provides ProjManagePresenter provideProjManagePresenter(ProjManageActivity activity) {
    return new ProjManagePresenterImpl(activity);
  }
}