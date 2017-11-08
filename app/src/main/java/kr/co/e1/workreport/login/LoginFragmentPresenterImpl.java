package kr.co.e1.workreport.login;

import android.os.Bundle;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import kr.co.e1.workreport.main.LoginCommunicationListener;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.network.TokenResult;
import kr.co.e1.workreport.network.WorkReportService;

/**
 * Created by jaeho on 2017. 9. 27
 */

public class LoginFragmentPresenterImpl implements LoginFragmentPresenter {

  private LoginFragmentPresenter.View view;
  private LoginNetworking networking;
  private LoginCommunicationListener loginListener;
  @Nonnull private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Inject LoginFragmentPresenterImpl(LoginFragmentPresenter.View view, LoginNetworking networking,
      LoginCommunicationListener loginListener) {
    this.view = view;
    this.networking = networking;
    this.loginListener = loginListener;
    service = new NetworkHelper().getWorkReportService();
  }

  WorkReportService service;

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    String confidentialsClient = okhttp3.Credentials.basic("test", "test");
    //service.generateToken(confidentialsClient, "client_credentials", "")
    compositeDisposable.add(
        service.generateToken(confidentialsClient, "client_credentials", "")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(new Function<TokenResult, String>() {
          @Override public String apply(TokenResult tokenResult) throws Exception {
            return tokenResult.getAccess_token();
          }
        }).subscribe(new Consumer<String>() {
          @DebugLog @Override public void accept(String s) throws Exception {
            Map<String, String> map = new HashMap<>();
            map.put("userId", "jhoh");
            map.put("userPw", "1111");
          }
        })
    );
  }

  @Override public void onPositiveClick(String id, String pw, LoginCommunicationListener listener) {
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }
}