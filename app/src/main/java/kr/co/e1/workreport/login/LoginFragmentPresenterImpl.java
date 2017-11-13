package kr.co.e1.workreport.login;

import android.os.Bundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.main.LoginCommunicationListener;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.WorkReportApi;

/**
 * Created by jaeho on 2017. 9. 27
 */

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

  private LoginFragmentPresenter.View view;
  private LoginCommunicationListener loginListener;
  private WorkReportApi workReportApi;
  private NetworkHelper networkHelper;
  @Nonnull private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Inject LoginFragmentPresenterImpl(LoginFragmentPresenter.View view, NetworkHelper networkHelper,
      LoginCommunicationListener loginListener) {
    this.view = view;
    this.loginListener = loginListener;
    this.networkHelper = networkHelper;
    this.workReportApi = networkHelper.getWorkReportApi();
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override public void onPositiveClick(String id, String pw) {
    view.showProgress();
    String confidentialsClient = networkHelper.getConfidentialsClient();
    String grantType = networkHelper.getGrantType();
    String scope = networkHelper.getScope();
    compositeDisposable.add(workReportApi.generateToken(confidentialsClient, grantType, scope)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(tokenResult -> {
          PreferencesUtils.setToken(tokenResult.getToken_type(), tokenResult.getAccess_token());
          Map<String, String> userMap = new HashMap<>();
          userMap.put("userId", id);
          userMap.put("userPw", pw);
          workReportApi.getLoginResult(PreferencesUtils.getToken(), userMap)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(wlResult -> {
                if (wlResult.getResult() == NetworkHelper.RESULT_SUCCESS) {
                  loginListener.loginComplete();
                  view.dismiss();
                } else {
                  view.showMessage(wlResult.getMsg());
                }
                view.hideProgress();
              }, throwable -> {
                view.hideProgress();
                view.showMessage(R.string.error_server_error);
              });
        }, throwable -> {
          view.hideProgress();
          view.showMessage(R.string.error_server_error);
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}