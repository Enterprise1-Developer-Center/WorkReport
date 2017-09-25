package kr.co.e1.workreport.main;

import android.os.Bundle;
import javax.inject.Inject;

/**
 * Created by jaeho on 2017. 9. 25
 */

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;

  @Inject public MainPresenterImpl(MainPresenter.View view) {
    this.view = view;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    view.setListener();
  }
}
