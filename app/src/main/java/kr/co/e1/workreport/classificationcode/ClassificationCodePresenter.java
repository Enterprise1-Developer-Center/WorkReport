package kr.co.e1.workreport.classificationcode;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 24
 */

public interface ClassificationCodePresenter {

  void onCreated(Bundle savedInstanceState);

  void onBackPressed();

  interface View {
    void setRecyclerView();

    void refresh();

    void finishActivity();
  }
}