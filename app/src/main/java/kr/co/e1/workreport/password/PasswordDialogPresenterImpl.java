package kr.co.e1.workreport.password;

import android.os.Bundle;
import android.text.TextUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.network.WResult;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialogPresenterImpl implements PasswordDialogPresenter {

  private PasswordDialogPresenter.View view;
  private PasswordNetwork network;

  public PasswordDialogPresenterImpl(PasswordDialogPresenter.View view, PasswordNetwork network) {
    this.view = view;
    this.network = network;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
  }

  @Override public void onRefresh() {
    view.clear();
    view.hideProgress();
  }

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override public void onPositiveClick(String nowPw, String newPw, String newPwConfirm) {
    if (TextUtils.isEmpty(nowPw) || TextUtils.isEmpty(newPw) || TextUtils.isEmpty(newPwConfirm)) {
      view.showMessage(R.string.please_enter_all);
      return;
    }
    view.showProgress();
    compositeDisposable.add(network.changePw(nowPw, newPw, newPwConfirm)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          if (result.getResult() == WResult.RESULT_SUCCESS) {
            view.hideProgress();
            view.dismiss();
          } else {
            view.hideProgress();
            view.showMessage(result.getMsg());
          }
        }, throwable -> {
          view.showMessage(R.string.error_server_error);
          view.hideProgress();
        }));
  }
}
