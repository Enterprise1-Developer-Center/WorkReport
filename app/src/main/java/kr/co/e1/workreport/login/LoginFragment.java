package kr.co.e1.workreport.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 25
 */

public class LoginFragment extends BaseFragment implements LoginFragmentPresenter.View {

  @Inject LoginFragmentPresenter presenter;
  @BindView(R.id.id_edittext) EditText idEdittext;
  @BindView(R.id.pw_edittext) EditText pwEdittext;
  @BindView(R.id.login_button) ImageView loginButton;

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

  @OnClick(R.id.login_button) void onLoginClick() {
    ((LoginCommunicationListener) getActivity()).startMain();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    Log.d("OJH", "onDestroyView");
  }

  @Override public void setEditTextFilter() {
    InputFilter idFilter = (source, start, end, dest, dstart, dend) -> {
      Pattern p = Pattern.compile("^[a-z]*$");
      if (!p.matcher(source).matches()) {
        return "";
      }
      return null;
    };
    idEdittext.setFilters(new InputFilter[]{idFilter});
    pwEdittext.setOnKeyListener((view, keyCode, keyEvent) -> {
      if(keyCode == KeyEvent.KEYCODE_SPACE) {
        return true;
      }
      return false;
    });
  }
}
