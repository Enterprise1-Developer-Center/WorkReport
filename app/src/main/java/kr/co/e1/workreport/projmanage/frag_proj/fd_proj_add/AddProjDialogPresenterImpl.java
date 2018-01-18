package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.utils.DateUtils;
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

  @Override public void onClick(int id) {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    switch (id) {
      case R.id.start_date_edittext:
        view.showStartDatePickerDialog(year, month, day);
        break;
      case R.id.end_date_edittext:
        view.showEndDatePickerDialog(year, month, day);
        break;
      case R.id.dept_name_edittext:
        processDepts();
        break;
    }
  }

  private List<Dept> depts = new ArrayList<>();

  @DebugLog private void processDepts() {
    compositeDisposable.add(network.getDepts()
        .subscribeOn(Schedulers.io())
        .map(result -> {
          depts.clear();
          depts.addAll(result.getContent());
          return Dept.convertToNameArray(result.getContent());
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(items -> {
          view.showDeptCodeListDialog(items);
        }, throwable -> {
          Timber.d(throwable);
          view.showMessage(throwable.getMessage());
        }));
  }

  @Override public void onStartDateSet(int year, int month, int day) {
    view.showStartDate(DateUtils.getDateString(year, month, day, "yyyyMMdd"));
  }

  @Override public void onEndDateSet(int year, int month, int day) {
    view.showEndDate(DateUtils.getDateString(year, month, day, "yyyyMMdd"));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onDeptsItemClick(String dept) {
    view.showDeptName(dept);
  }

  @Override
  public void onAddClick(String projCode, String projName, String startDate, String endDate,
      String deptName) {
    view.setButtonEnabled(false);

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
}