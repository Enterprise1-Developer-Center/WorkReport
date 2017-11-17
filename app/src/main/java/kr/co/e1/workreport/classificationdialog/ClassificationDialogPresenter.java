package kr.co.e1.workreport.classificationdialog;

import android.os.Bundle;
import android.support.annotation.StringRes;
import kr.co.e1.workreport.common.model.DetailWork;

/**
 * Created by jaeho on 2017. 10. 24
 */

public interface ClassificationDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState, String work);

  void onPositiveClick(String work);

  interface View {
    void setRecyclerView();

    void refresh();

    void hideProgress();

    void showProgress();

    void showMessage(@StringRes int resId);

    void showWork(String work);

    void dismiss(DetailWork selectedItem);
  }
}