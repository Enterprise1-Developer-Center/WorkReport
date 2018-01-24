package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.framework.utils.MyTextUtils;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.network.NetworkHelper;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.model.EditEmpNetModel;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.network.EditEmpNetwork;
import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;
import timber.log.Timber;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class EditEmpDialogPresenterImpl implements EditEmpDialogPresenter {

  private View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private EditEmpNetwork network;
  private EditEmpNetModel netModel;

  public EditEmpDialogPresenterImpl(View view, EditEmpNetwork network) {
    this.view = view;
    this.network = network;
    this.netModel = new EditEmpNetModel();
  }

  @Override public void onActivityCreate(Employee item) {
    netModel.initialize(item);
    view.setListener();
    view.disableLayout();

    view.showUserName(netModel.getUser_nm());
    view.showProjName(netModel.getProj_nm());
    view.showStartDate(DateUtils.convertStringToFormatString(netModel.getUser_sdate(), "yyyyMMdd",
        "yyyy-MM-dd (EEE)", Locale.KOREA));
    view.showEndDate(
        DateUtils.convertStringToFormatString(netModel.getUser_edate(), "yyyyMMdd", "yyyy-MM-dd (EEE)",
            Locale.KOREA));
    view.showClassCode(netModel.getMcls_cd());
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  private Map<String, String> getEditFieldMap() {
    Map<String, String> fieldMap = new HashMap<>();

    fieldMap.put("USER_SDATE", netModel.getUser_sdate());
    fieldMap.put("USER_EDATE", netModel.getUser_edate());
    fieldMap.put("LCLS_CD", netModel.getLcls_cd());
    fieldMap.put("MCLS_CD", netModel.getMcls_cd());
    fieldMap.put("PROJ_CD", netModel.getProj_cd());
    fieldMap.put("USER_ID", netModel.getUser_id());

    return fieldMap;
  }

  @Override public void onEditClick() {
    view.setButtonEnabled(false);
    compositeDisposable.add(network.editEmployee(getEditFieldMap())
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
          Timber.d(throwable.getMessage());
          view.showMessage(throwable.getMessage());
          view.setButtonEnabled(true);
        }));
  }

  @Override public void onDelClick() {
    view.setButtonEnabled(false);
    Map<String, String> fieldMap = new HashMap<>();
    fieldMap.put("PROJ_CD", netModel.getProj_cd());
    fieldMap.put("USER_ID", netModel.getUser_id());

    compositeDisposable.add(network.delEmployee(fieldMap)
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
          view.showMessage(throwable.getMessage());
          view.setButtonEnabled(true);
        }));
  }

  @Override public void onUserNameEditTextClick(final String userName) {
    compositeDisposable.add(network.getUsers()
        .subscribeOn(Schedulers.io())
        .map(result -> result.getContent())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(users -> {
          final String[] userNames = User.convertToNameArray(users);
          int checkedItem = User.indexOf(netModel.getUser_id(), users);
          view.showUserChoiceDialog(userNames, checkedItem, (dialogInterface, which) -> {
            netModel.setUser_id((users.get(which).getUser_id()))
                .setUser_nm(users.get(which).getUser_nm());
            view.showUserName(userNames[which]);
            dialogInterface.dismiss();
          });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }

  @Override public void onProjNameEditTextClick(final String projName) {
    compositeDisposable.add(network.getProjects2()
        .subscribeOn(Schedulers.io())
        .map(result -> result.getContent())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(projects -> {
          final String[] projectNames = Project.convertToNameArray(projects);
          int checkedItem = Project.indexOf(netModel.getProj_cd(), projects);
          view.showProjNamesChoiceDialog(projectNames, checkedItem, (dialogInterface, which) -> {
            netModel.setProj_cd(projects.get(which).getProj_cd())
                .setProj_nm(projects.get(which).getProj_nm());
            view.showProjName(projectNames[which]);
            dialogInterface.dismiss();
          });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }

  @Override public void onStartDateEditTextClick(String startDate) {
    Calendar cal = Calendar.getInstance();
    int $year = cal.get(Calendar.YEAR);
    int $month = cal.get(Calendar.MONTH);
    int $dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

    if (!MyTextUtils.isBlank(startDate)) {
      cal.setTime(DateUtils.convertStringToDate(startDate, "yyyy-MM-dd (EEE)", Locale.KOREA));
      $year = cal.get(Calendar.YEAR);
      $month = cal.get(Calendar.MONTH);
      $dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
    }

    view.showStartDatePickerDialog($year, $month, $dayOfMonth,
        (picker, year, month, dayOfMonth) -> {
          netModel.setUser_sdate(DateUtils.getDateString(year, month, dayOfMonth, "yyyyMMdd"));

          view.showStartDate(
              DateUtils.getDateString(year, month, dayOfMonth, "yyyy-MM-dd (EEE)", Locale.KOREA));
        });
  }

  @Override public void onEndDateEditTextClick(String endDate) {
    Calendar cal = Calendar.getInstance();
    int $year = cal.get(Calendar.YEAR);
    int $month = cal.get(Calendar.MONTH);
    int $dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

    if (!MyTextUtils.isBlank(endDate)) {
      cal.setTime(DateUtils.convertStringToDate(endDate, "yyyy-MM-dd (EEE)", Locale.KOREA));
      $year = cal.get(Calendar.YEAR);
      $month = cal.get(Calendar.MONTH);
      $dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
    }

    view.showEndDatePickerDialog($year, $month, $dayOfMonth, (picker, year, month, dayOfMonth) -> {
      netModel.setUser_edate(DateUtils.getDateString(year, month, dayOfMonth, "yyyyMMdd"));
      view.showEndDate(
          DateUtils.getDateString(year, month, dayOfMonth, "yyyy-MM-dd (EEE)", Locale.KOREA));
    });
  }

  @Override public void onClassEditTextClick(final String mclsCode) {
    compositeDisposable.add(network.getCode()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          int checkedItem = DetailWork.indexOf(netModel.getMcls_cd(), result.getContent());
          view.showClassChoiceDialog(result.getContent(), checkedItem,
              (detailWork, dialogInterface) -> {
                netModel.setMcls_cd(detailWork.getMcls_cd()).setLcls_cd(detailWork.getLcls_cd());
                view.showClassCode(detailWork.getMcls_cd());
                dialogInterface.dismiss();
              });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }
}