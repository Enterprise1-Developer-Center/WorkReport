package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import android.content.DialogInterface;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.Locale;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.framework.utils.MyTextUtils;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.network.AddEmpNetwork;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddEmpDialogPresenterImpl implements AddEmpDialogPresenter {

  private View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private AddEmpNetwork network;

  public AddEmpDialogPresenterImpl(View view, AddEmpNetwork network) {
    this.view = view;
    this.network = network;
  }

  @DebugLog @Override public void onStartDateSet(int year, int month, int day) {
    view.showStartDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd (EEE)", Locale.KOREA));
  }

  @DebugLog @Override public void onEndDateSet(int year, int month, int day) {
    view.showEndDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd (EEE)", Locale.KOREA));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onEmpsItemClick(String dept) {
    view.showEmp(dept);
  }

  @Override
  public void onAddClick(String projCode, String projName, String $startDate, String $endDate,
      String deptName) {
  }

  @Override public void onStartDateEditTextClick(String startDate) {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);

    if (!MyTextUtils.isBlank(startDate)) {
      cal.setTime(DateUtils.convertStringToDate(startDate, "yyyy-MM-dd (EEE)", Locale.KOREA));
      year = cal.get(Calendar.YEAR);
      month = cal.get(Calendar.MONTH);
      day = cal.get(Calendar.DAY_OF_MONTH);
    }

    view.showStartDatePickerDialog(year, month, day);
  }

  @Override public void onEndDateEditTextClick(String endDate) {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);

    if (!MyTextUtils.isBlank(endDate)) {
      cal.setTime(DateUtils.convertStringToDate(endDate, "yyyy-MM-dd (EEE)", Locale.KOREA));
      year = cal.get(Calendar.YEAR);
      month = cal.get(Calendar.MONTH);
      day = cal.get(Calendar.DAY_OF_MONTH);
    }

    view.showEndDatePickerDialog(year, month, day);
  }

  @Override public void onEmpTypeEditTextClick(String deptName) {

  }

  @Override public void onUserNameEditTextClick(final String userName) {
    compositeDisposable.add(network.getUsers()
        .subscribeOn(Schedulers.io())
        .map(result -> User.convertToNameArray(result.getContent()))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(names -> view.showUserChoiceDialog(names, User.indexOf(names, userName)),
            throwable -> view.showMessage(throwable.getMessage())));
  }

  @Override public void onProjNameEditTextClick(String projName) {
    //view.showProjNameChoiceDialog();
    //compositeDisposable.add(network.getUsers())
  }

  @Override public void onUserNameOfDialogListClick(DialogInterface dialog, String userName) {
    view.showUserName(userName);
    dialog.dismiss();
  }
}