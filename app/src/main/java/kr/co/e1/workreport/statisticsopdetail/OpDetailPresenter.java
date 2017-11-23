package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface OpDetailPresenter {

  void onCreated(Bundle savedInstanceState);

  void onDestroy();

  interface View {

    void setRecyclerView();

    void refresh();

    void hideProgress();

    void showProgress();

    void refresh(int position);

    void showMessage(@StringRes int resId);

    void showMessage(String msg);
  }
}
