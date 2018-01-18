package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.framework.utils.MyTextUtils;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.model.Dept;
import kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add.network.AddProjNetwork;
import timber.log.Timber;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddProjDialogPresenterImpl implements AddProjDialogPresenter {

  private AddProjDialogPresenter.View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private AddProjNetwork network;

  public AddProjDialogPresenterImpl(AddProjDialogPresenter.View view, AddProjNetwork network) {
    this.view = view;
    this.network = network;
  }

  private List<Dept> depts = new ArrayList<>();

  @DebugLog @Override public void onStartDateSet(int year, int month, int day) {
    view.showStartDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd (EEE)", Locale.KOREA));
  }

  @DebugLog @Override public void onEndDateSet(int year, int month, int day) {
    view.showEndDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd (EEE)", Locale.KOREA));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onDeptsItemClick(String dept) {
    view.showDeptName(dept);
  }

  @Override
  public void onAddClick(String projCode, String projName, String $startDate, String $endDate,
      String deptName) {
    view.setButtonEnabled(false);

    String startDate =
        DateUtils.convertStringToFormatString($startDate, "yyyy-MM-dd (EEE)", "yyyMMdd",
            Locale.KOREA);
    String endDate = DateUtils.convertStringToFormatString($endDate, "yyyy-MM-dd (EEE)", "yyyMMdd",
        Locale.KOREA);
    HashMap<String, String> fieldMap = new HashMap<>();
    fieldMap.put("PROJ_CD", projCode);
    fieldMap.put("PROJ_NM", projName);
    fieldMap.put("PROJ_SDATE", startDate);
    fieldMap.put("PROJ_EDATE", endDate);
    fieldMap.put("DEPT_CD", Dept.getCode(deptName, depts));
    compositeDisposable.add(network.addProject(fieldMap)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(wResult -> {
          if (wResult.getResult() == NetworkHelper.RESULT_SUCCESS) {
            view.showSuccessMessage(wResult.getMsg());
          } else {
            view.showMessage(wResult.getMsg());
          }
          view.setButtonEnabled(true);
        }, throwable -> {
          Timber.d(throwable);
          //view.showMessage(R.string.error_server_error);
          view.showMessage(throwable.getMessage().toString());
          view.setButtonEnabled(true);
        }));
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

  @Override public void onDeptNameEditText(String deptName) {
    compositeDisposable.add(network.getDepts().subscribeOn(Schedulers.io()).map(result -> {
      depts.clear();
      depts.addAll(result.getContent());
      return Dept.convertToNameArray(result.getContent());
    }).observeOn(AndroidSchedulers.mainThread()).subscribe(items -> {
      view.showDeptCodeListDialog(items, Dept.convertNameToPosition(deptName, items));
    }, throwable -> {
      Timber.d(throwable);
      view.showMessage(throwable.getMessage());
    }));
  }
}