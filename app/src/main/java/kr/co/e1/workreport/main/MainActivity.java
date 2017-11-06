package kr.co.e1.workreport.main;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import hugo.weaving.DebugLog;
import java.util.Calendar;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classificationdialog.ClassificationDialog;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.login.LoginFragment;
import kr.co.e1.workreport.password.PasswordDialog;
import kr.co.e1.workreport.project.ProjectDialog;
import kr.co.e1.workreport.statistics.StatisticsActivity;
import kr.co.e1.workreport.teamreport.TeamReportActivity;
import timber.log.Timber;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener, MainPresenter.View,
    LoginCommunicationListener {

  @Inject MainPresenter presenter;
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.navigation_view) NavigationView navigationView;
  @BindView(R.id.save_button) ImageView saveButton;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.date_textview) TextView dateTextView;
  @BindView(R.id.start_time_textview) TextView startTimeTextView;
  @BindView(R.id.end_time_textview) TextView endTimeTextView;
  @BindView(R.id.group_textview) TextView groupTextView;
  @BindView(R.id.person_textview) TextView personTextView;
  @BindView(R.id.code_textview) TextView codeTextView;
  @BindView(R.id.project_textview) TextView projectTextView;
  @BindView(R.id.last_edit_textview) TextView lastEditTextView;
  @BindView(R.id.work_time_textview) TextView workTimeTextView;

  @Override protected void onCreated(Bundle savedInstanceState) {
    presenter.onCreate(savedInstanceState);
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
    new LoginFragment().show(getSupportFragmentManager(), LoginFragment.class.getSimpleName());
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

  @OnClick({
      R.id.date_container, R.id.start_time_container, R.id.end_time_container, R.id.code_container,
      R.id.project_container, R.id.save_button
  }) public void onClick(View view) {
    presenter.onClick(view.getId());
  }

  @Override public void showReportDatePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int cYear = calendar.get(Calendar.YEAR);
    int cMonth = calendar.get(Calendar.MONTH);
    int cDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    Timber.d("year = " + cYear + ", month = " + cMonth + ", day = " + cDayOfMonth);

    new DatePickerDialog(this, (datePicker, year, month, dayOfMonth) -> {
      presenter.onReportDateSet(year, month, dayOfMonth);
    }, cYear, cMonth, cDayOfMonth).show();
  }

  @Override public void showReportDate(String date) {
    dateTextView.setText(date);
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void enableSaveButton() {
    saveButton.setEnabled(true);
    saveButton.setColorFilter(
        ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
  }

  @Override public void disableSaveButton() {
    saveButton.setEnabled(false);
    saveButton.setColorFilter(
        ContextCompat.getColor(getApplicationContext(), R.color.colorIndigo_100));
  }

  @Override public void showStartTimePickerDialog() {

    Calendar calendar = Calendar.getInstance();
    int cHourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    int cMinute = calendar.get(Calendar.MINUTE);

    new TimePickerDialog(this, (view, hourOfDay, minute) -> {
      presenter.onStartTimeSet(hourOfDay, minute);
    }, cHourOfDay, cMinute, true).show();
  }

  @Override public void showEndTimePickerDialog() {

    Calendar calendar = Calendar.getInstance();
    int cHourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    int cMinute = calendar.get(Calendar.MINUTE);

    new TimePickerDialog(this, (view, hourOfDay, minute) -> {
      presenter.onEndTimeSet(hourOfDay, minute);
    }, cHourOfDay, cMinute, true).show();
  }

  @Override public void showStartTime(String startTime) {
    startTimeTextView.setText(startTime);
  }

  @Override public void showEndTime(String endTime) {
    endTimeTextView.setText(endTime);
  }

  @Override public void showGroup(String group) {
    groupTextView.setText(group);
  }

  @Override public void showPerson(String person) {
    personTextView.setText(person);
  }

  @Override public void showCode(String code) {
    codeTextView.setText(code);
  }

  @Override public void showProject(String project) {
    projectTextView.setText(project);
  }

  @Override public void showLastEditDateTime(String lastEditDateTime) {
    lastEditTextView.setText(lastEditDateTime);
  }

  @Override public void showWorkTime(String workTime) {
    workTimeTextView.setText(workTime);
  }

  @Override public void showCodeDialogFragment() {
    new ClassificationDialog().setOnDialogClickListener(
        o -> codeTextView.setText(o.getString("code") + " / " + o.getString("work")))
        .show(getSupportFragmentManager(), ClassificationDialog.class.getSimpleName());
  }

  @Override public void showProjectChoiceDialog() {
    new ProjectDialog().setOnDialogClickListener(o -> projectTextView.setText(o.getString("name")))
        .show(getSupportFragmentManager(), ProjectDialog.class.getSimpleName());
  }

  @Override public void showSnakeBar(int resId) {
    Snackbar.make(rootView, resId, Snackbar.LENGTH_SHORT).show();
  }

  @Override public boolean onNavigationItemSelected(MenuItem item) {
    presenter.onNavigationItemSelected(item.getItemId());
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override public void loginComplete() {
    presenter.loginComplete();
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}