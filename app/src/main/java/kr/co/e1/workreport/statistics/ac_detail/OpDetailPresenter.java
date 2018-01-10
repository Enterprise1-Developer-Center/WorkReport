package kr.co.e1.workreport.statistics.ac_detail;

import android.content.Intent;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface OpDetailPresenter {

  void onDestroy();

  void onCreated(Intent intent);

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
