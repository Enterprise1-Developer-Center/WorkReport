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
    String confidentialsClient = networkHelper.getConfidentialsClient();
    String grantType = networkHelper.getGrantType();
    String scope = networkHelper.getScope();
    compositeDisposable.add(workReportApi.generateToken(confidentialsClient, grantType, scope)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(tokenResult -> {
          Map<String, String> h = new HashMap<>();
          h.put("userId", id);
          h.put("userPw", pw);
          workReportApi.getLoginResult(
              tokenResult.getToken_type() + " " + tokenResult.getAccess_token(), h)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(wlResult -> {
                if (wlResult.getResult() == NetworkHelper.RESULT_SUCCESS) {
                  loginListener.loginComplete();
                  view.dismiss();
                } else {
                  view.showMessage(wlResult.getMsg());
                }
              }, throwable -> view.showMessage(R.string.error_server_error));
        }));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}