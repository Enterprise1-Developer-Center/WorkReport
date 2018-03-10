package kr.co.e1.workreport.main.dg_login;

import android.os.Bundle;
import com.worklight.common.WLAnalytics;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.main.LoginCommunicationListener;
import kr.co.e1.workreport.main.dg_login.model.LoginContent;
import kr.co.e1.workreport.main.dg_login.network.LoginNetwork;
import kr.co.e1.workreport.network.TokenResult;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 9. 27
 */

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

  private LoginFragmentPresenter.View view;
  private LoginCommunicationListener loginListener;
  private LoginNetwork network;
  @Nonnull private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public LoginFragmentPresenterImpl(LoginFragmentPresenter.View view, LoginNetwork network,
      LoginCommunicationListener loginListener) {
    this.view = view;
    this.loginListener = loginListener;
    this.network = network;
  }

  @Override public void onPositiveClick(final String id, final String pw) {
    view.showProgress();
    view.setButtonEnabled(false);
    compositeDisposable.add(network.generateToken()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((TokenResult tokenResult) -> {

          PreferencesUtils.setToken(tokenResult.getToken_type(), tokenResult.getAccess_token());
          final Map<String, String> userMap = new HashMap<>();
          userMap.put("userId", id);
          userMap.put("userPw", pw);

          compositeDisposable.add(network.getLoginResult(userMap)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(result -> {
                LoginContent content = result.getContent();
                if (result.getResult() == WResult.RESULT_SUCCESS) {
                  PreferencesUtils.setUserId(content.getUserId());
                  PreferencesUtils.setDept(content.getDeptNm());
                  PreferencesUtils.setToday(content.getDate());
                  PreferencesUtils.setDeptCd(content.getDeptCd());
                  PreferencesUtils.setAdmin(content.isAdmin());
                  WLAnalytics.setUserContext(id);
                  loginListener.onLoginSuccess(content.getDate(), content.isAdmin());
                  view.dismiss();
                } else {
                  view.showMessage(result.getMsg());
                }
                view.hideProgress();
                view.setButtonEnabled(true);
              }, throwable -> {
                view.hideProgress();
                view.setButtonEnabled(true);
                view.showMessage(R.string.error_server_error);
              }));
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.setButtonEnabled(true);
          view.hideProgress();
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}