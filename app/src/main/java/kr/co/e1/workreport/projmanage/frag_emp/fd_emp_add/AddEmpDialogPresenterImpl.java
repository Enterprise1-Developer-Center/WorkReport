package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.Locale;
import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.framework.utils.DateUtils;
import kr.co.e1.workreport.framework.utils.MyTextUtils;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.model.AddEmpModelWrapper;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.model.UserType;
import kr.co.e1.workreport.projmanage.frag_emp.fd_emp_add.network.AddEmpNetwork;
import kr.co.e1.workreport.projmanage.frag_emp.model.User;
import timber.log.Timber;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddEmpDialogPresenterImpl implements AddEmpDialogPresenter {

  private View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private AddEmpNetwork network;
  private AddEmpModelWrapper modelWrapper;

  public AddEmpDialogPresenterImpl(View view, AddEmpNetwork network) {
    this.view = view;
    this.network = network;
    this.modelWrapper = new AddEmpModelWrapper();
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override
  public void onAddClick(String projCode, String projName, String $startDate, String $endDate,
      String deptName) {
    Timber.d("modelWrapper = " + modelWrapper);
  }

  @Override public void onUserNameEditTextClick(final String userName) {
    compositeDisposable.add(network.getUsers()
        .subscribeOn(Schedulers.io())
        .map(result -> result.getContent())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(users -> {
          final String[] userNames = User.convertToNameArray(users);
          final int checkedItem = User.indexOf(modelWrapper.getUser(), users);
          view.showUserChoiceDialog(userNames, checkedItem, (dialogInterface, which) -> {
            modelWrapper.setUser(users.get(which));
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
          final int checkedItem = Project.indexOf(modelWrapper.getProject(), projects);
          view.showProjNamesChoiceDialog(projectNames, checkedItem, (dialogInterface, which) -> {
            modelWrapper.setProject(projects.get(which));
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
          modelWrapper.setStartDate(DateUtils.getDateString(year, month, dayOfMonth, "yyyyMMdd"));
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
      modelWrapper.setEndDate(DateUtils.getDateString(year, month, dayOfMonth, "yyyyMMdd"));
      view.showEndDate(
          DateUtils.getDateString(year, month, dayOfMonth, "yyyy-MM-dd (EEE)", Locale.KOREA));
    });
  }

  @Override public void onUserTypeEditTextClick(final String typeName) {
    compositeDisposable.add(network.getUserTypes()
        .subscribeOn(Schedulers.io())
        .map(result -> result.getContent())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userTypes -> {
          final String[] names = UserType.convertToNameArray(userTypes);
          final int checkedItem = UserType.indexOf(modelWrapper.getUserType(), userTypes);
          view.showUserTypeChoiceDialog(names, checkedItem, (dialogInterface, which) -> {
            modelWrapper.setUserType(userTypes.get(which));
            view.showUserType(names[which]);
            dialogInterface.dismiss();
          });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }

  @Override public void onClassEditTextClick(final String mclsCode) {
    compositeDisposable.add(network.getCode()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
          final int checkedItem =
              DetailWork.indexOf(modelWrapper.getDetailWork(), result.getContent());
          view.showClassChoiceDialog(result.getContent(), checkedItem,
              (detailWork, dialogInterface) -> {
                modelWrapper.setDetailWork(detailWork);
                view.showClassCode(detailWork.getMcls_cd());
                dialogInterface.dismiss();
              });
        }, throwable -> view.showMessage(throwable.getMessage())));
  }
}