package kr.co.e1.workreport.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2017. 9. 25
 */

public class LoginFragment extends BaseFragment implements LoginFragmentPresenter.View {

  @Inject LoginFragmentPresenter presenter;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_login;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  public static Fragment newInstance(Bundle args) {
    LoginFragment f = new LoginFragment();
    f.setArguments(args);
    return f;
  }

  @Override public void onAttach(Context context) {
    AndroidSupportInjection.inject(this);
    super.onAttach(context);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    Log.d("OJH", "onDestroyView");
  }
}
