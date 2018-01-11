package kr.co.e1.workreport.main;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import hugo.weaving.DebugLog;
import javax.inject.Inject;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.main.dg_class.ClassificationDialog;
import kr.co.e1.workreport.common.Constants;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.common.model.ReportEntry;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.framework.interfaces.OnRecyclerItemClickListener;
import kr.co.e1.workreport.main.dg_login.LoginFragment;
import kr.co.e1.workreport.main.adapter.MainAdapterView;
import kr.co.e1.workreport.main.adapter.MainReportAdapter;
import kr.co.e1.workreport.main.adapter.OnSaveButtonClickListener;
import kr.co.e1.workreport.main.model.SummaryReportContent;
import kr.co.e1.workreport.main.dg_pass.PasswordDialog;
import kr.co.e1.workreport.main.dg_proje.ProjectDialog;
import kr.co.e1.workreport.main.dg_proje.vo.Project;
import kr.co.e1.workreport.statistics.StatisticsActivity;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import timber.log.Timber;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener, MainPresenter.View,
    LoginCommunicationListener, OnRecyclerItemClickListener<ReportEntry>,
    OnSaveButtonClickListener<SummaryReportContent> {

  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.navigation_view) NavigationView navigationView;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @Inject MainReportAdapter adapter;
  @Inject MainAdapterView adapterView;
  @Inject MainPresenter presenter;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreate(savedInstanceState);
    Timber.d("adapter = " + adapter);
  }

  @Override public void setListener() {
    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    navigationView.setNavigationItemSelectedListener(this);
  }

  @DebugLog @Override public void showLoginFragment(Bundle savedInstanceState) {
    new LoginFragment().setLoginCommunicationListener(this)
        .show(getSupportFragmentManager(), LoginFragment.class.getSimpleName());
  }

  @Override public void showPasswordChangeDialog() {
    new PasswordDialog().show(getSupportFragmentManager(), PasswordDialog.class.getSimpleName());
  }

  @Override public void changeTheme() {
    setTheme(R.style.AppTheme_NoActionBar);
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override protected int getTitleResId() {
    return R.string.app_name;
  }

  @Override protected boolean isDisplayHomeAsUpEnabled() {
    return false;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public void onBackPressed() {
    presenter.onBackPressed(drawer.isDrawerOpen(GravityCompat.START));
  }

  @Override public void closeDrawer() {
    drawer.closeDrawer(GravityCompat.START);
  }

  @Override public void navigateToStatistics() {
    Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
    startActivity(intent);
  }

  @Override public void navigateToTeamReport() {
    Intent intent = new Intent(getApplicationContext(), TeamReportActivity.class);
    startActivity(intent);
  }

  @Override public void navigateToReview() {
    new AlertDialog.Builder(this).setTitle("Review").setMessage("Please write review").show();
  }

  @Override public void showDatePickerDialog(int year, int month, int day,
      DatePickerDialog.OnDateSetListener listener) {
    new DatePickerDialog(this, listener, year, month, day).show();
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @DebugLog @Override public void showClassificationDialog(DetailWork nowDetailWork) {
    new ClassificationDialog().setNowDetailWork(nowDetailWork)
        .setOnDialogClickListener(o -> presenter.onDetailWorkDialogClick(o))
        .show(getSupportFragmentManager(), ClassificationDialog.class.getSimpleName());
  }

  @Override public void showProjectChoiceDialog(Project nowProject) {
    new ProjectDialog().setNowProject(nowProject)
        .setOnDialogClickListener(o -> presenter.onProjectDialogClick(o))
        .show(getSupportFragmentManager(), ProjectDialog.class.getSimpleName());
  }

  @Override public void showMessage(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void showMessage(String msg) {
    Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
  }

  @Override public void refreshRemove() {
    adapterView.refreshRemove();
  }

  @Override public void navigateToProjectManage() {

  }

  @Override public void setRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.setAdapter(adapter);
    recyclerView.setItemAnimator(new SlideInDownAnimator());
    recyclerView.getItemAnimator().setAddDuration(Constants.ANI_DURATION);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void refresh(int position) {
    adapterView.refresh(position);
  }

  @Override public void showTimePickerDialog(int hour, int minute,
      TimePickerDialog.OnTimeSetListener listener) {

    new TimePickerDialog(this, listener, hour, minute, true).show();
  }

  @Override public boolean onNavigationItemSelected(MenuItem item) {
    presenter.onNavigationItemSelected(item.getItemId());
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @DebugLog @Override public void onLoginSuccess(String date) {
    presenter.onLoginSuccess(date);
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }

  @Override public void onItemClick(ReportEntry item) {
    presenter.onItemClick(item);
  }

  @DebugLog @Override public void onSaveClick(SummaryReportContent content) {
    presenter.onSaveClick(content);
  }

  @Override protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }
}