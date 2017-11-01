package kr.co.e1.workreport.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.BindView;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import kr.co.e1.workreport.framework.SystemUtility;
import kr.co.e1.workreport.main.LoginCommunicationListener;

/**
 * Created by jaeho on 2017. 9. 25
 */

public class LoginFragment extends BaseAlertDialogFragment implements LoginFragmentPresenter.View {

  @Inject LoginFragmentPresenter presenter;
  @BindView(R.id.id_edittext) EditText idEdittext;
  @BindView(R.id.pw_edittext) EditText pwEdittext;
  @BindView(R.id.id_edittext_layout) TextInputLayout idEdittextLayout;
  @BindView(R.id.pw_edittext_layout) TextInputLayout pwEdittextLayout;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @Override protected int getLayoutResId() {
    return R.layout.fragment_login;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.login;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {
      String id = idEdittext.getText().toString().trim();
      String pw = pwEdittext.getText().toString().trim();
      LoginCommunicationListener listener = (LoginCommunicationListener) getActivity();
      presenter.onPositiveClick(id, pw, listener);
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      getActivity().finish();
    };
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
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
    idEdittext.setFilters(new InputFilter[] { idFilter });
    pwEdittext.setOnKeyListener((view, keyCode, keyEvent) -> {
      if (keyCode == KeyEvent.KEYCODE_SPACE) {
        return true;
      }
      return false;
    });
  }

  @Override public void showIDError(String msg) {
    idEdittextLayout.setError(msg);
  }

  @Override public void showPWError(String msg) {
    pwEdittextLayout.setError(msg);
  }

  @Override public void hideKeyboard() {
    SystemUtility.hideKeyboard(getContext(), idEdittext);
    SystemUtility.hideKeyboard(getContext(), pwEdittext);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }
}
