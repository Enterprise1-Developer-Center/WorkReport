package kr.co.e1.workreport.statistics.dg_create;

import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2018. 1. 3
 */

public interface CreateDbPresenter {

  void onActivityCreate();

  void onDetach();

  void onStart();

  void onOkClick(int year);

  interface View {

    void setYear(int year, int maxYear, int minYear);

    void showMessage(@StringRes int resId);

    void showLoading();

    void hideLoading();

    void showMessage(String msg);

    void dismiss();

    void showIndefiniteSnakback(String msg);

    void setPositiveButtonText(@StringRes int text);
  }
}
