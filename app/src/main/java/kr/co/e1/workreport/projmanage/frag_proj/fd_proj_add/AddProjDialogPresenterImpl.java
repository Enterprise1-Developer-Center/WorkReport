package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.utils.DateUtils;
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
      case R.id.dept_cd_edittext:
        processDepts();
        break;
    }
  }

  @DebugLog private void processDepts() {
    compositeDisposable.add(network.getDepts()
        .subscribeOn(Schedulers.io())
        .map(result -> Dept.convertToNameArray(result.getContent()))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(items -> {
          view.showDeptCodeListDialog(items);
        }, throwable -> {
          Timber.d(throwable);
          view.showMessage(R.string.error_server_error);
        }));
  }

  @Override public void onStartDateSet(int year, int month, int day) {
    view.showStartDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd"));
  }

  @Override public void onEndDateSet(int year, int month, int day) {
    view.showEndDate(DateUtils.getDateString(year, month, day, "yyyy-MM-dd"));
  }

  @Override public void onDetach() {
    compositeDisposable.clear();
  }

  @Override public void onDeptsItemClick(String dept) {
    view.showDeptName(dept);
  }
}