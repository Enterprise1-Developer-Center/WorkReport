package kr.co.e1.workreport.teamreport;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface TeamReportPresenter {

  void onCreated(Bundle savedInstanceState);

  void onDestroy();

  interface View {

    void setRecyclerView();

    void refresh();

    void hideProgress();

    void showProgress();
  }
}
