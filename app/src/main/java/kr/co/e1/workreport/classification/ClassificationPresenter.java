package kr.co.e1.workreport.classification;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 24
 */

public interface ClassificationPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  interface View {
    void setRecyclerView();

    void refresh();
  }
}
