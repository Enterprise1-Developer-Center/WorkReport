package kr.co.e1.workreport.main;

import android.os.Bundle;

/**
 * Created by jaeho on 2017. 9. 25
 */

public interface MainPresenter {
  void onCreate(Bundle savedInstanceState);

  void onNavigationItemSelected(int itemId);

  void loginComplete();

  void onBackPressed(boolean isDrawerOpen, String fragmentName);

  interface View {
    void setListener();

    void showLoginFragment(Bundle savedInstanceState);

    void showPasswordChangeDialog();

    void changeTheme();

    void showReportFragment();

    void closeDrawer();

    void finish();

    void popBackStack(String name);

    void navigateToStatistics();

    void navigateToTeamReport();

    void navigateToReview();
  }
}
