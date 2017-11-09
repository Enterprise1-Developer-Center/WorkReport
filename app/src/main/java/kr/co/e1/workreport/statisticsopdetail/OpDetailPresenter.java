package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 31
 */

public interface OpDetailPresenter {

  void onCreated(Bundle savedInstanceState);


  interface View {

    void setRecyclerView();

    void refresh();
  }
}
