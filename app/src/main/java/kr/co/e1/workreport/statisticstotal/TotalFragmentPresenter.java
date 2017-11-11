package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by jaeho on 2017. 11. 2
 */

public interface TotalFragmentPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onClick(int id);

  interface View {

    void showProgress();

    void hideProgress();

    void showMessage(@StringRes int resId);

    void setRecyclerView();

    void refresh(int position);
  }
}
