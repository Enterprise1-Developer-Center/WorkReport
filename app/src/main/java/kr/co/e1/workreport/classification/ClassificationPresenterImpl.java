package kr.co.e1.workreport.classification;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationPresenterImpl implements ClassificationPresenter {

  private ClassificationPresenter.View view;

  ClassificationPresenterImpl(ClassificationPresenter.View view) {
    this.view = view;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();
  }
}
