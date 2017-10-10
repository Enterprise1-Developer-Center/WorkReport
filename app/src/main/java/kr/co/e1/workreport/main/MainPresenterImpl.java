package kr.co.e1.workreport.main;

import android.os.Bundle;
import javax.inject.Inject;
import kr.co.e1.workreport.R;

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

  @Override public void onNavigationItemSelected(int itemId) {
    if (itemId == R.id.nav_camera) {
      // Handle the camera action
    } else if (itemId == R.id.nav_gallery) {

    } else if (itemId == R.id.nav_slideshow) {

    } else if (itemId == R.id.nav_manage) {

    } else if (itemId == R.id.nav_share) {

    } else if (itemId == R.id.nav_send) {

    }
  }
}