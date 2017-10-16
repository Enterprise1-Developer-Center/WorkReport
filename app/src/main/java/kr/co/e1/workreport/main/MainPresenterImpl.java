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
    view.openLoginFragment(savedInstanceState);
  }

  @Override public void onNavigationItemSelected(int itemId) {
    if (itemId == R.id.nav_statistics) {
      // Handle the camera action
    } else if (itemId == R.id.nav_team_report) {

    } else if (itemId == R.id.nav_settings) {

    } else if (itemId == R.id.nav_review) {

    }
  }

  @Override public void startMain() {
    view.closeLoginFragment();
    view.setListener();
  }
}