package kr.co.e1.workreport.password;

import android.os.Bundle;
import android.os.Handler;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class PasswordDialogPresenterImpl implements PasswordDialogPresenter {

  private PasswordDialogPresenter.View view;

  public PasswordDialogPresenterImpl(PasswordDialogPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setListener();
  }

  @DebugLog @Override public void onOkClick() {
    view.showProgress();
    new Handler().postDelayed(() -> {
      view.hideProgress();
      //view.dismiss();
      view.showSnackBar(R.string.input_invalid_value);
    }, 2000);
  }

  @Override public void onRefresh() {
    view.clear();
    view.hideProgress();
  }
}
