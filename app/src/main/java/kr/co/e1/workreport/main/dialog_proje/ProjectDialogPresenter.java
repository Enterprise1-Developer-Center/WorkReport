package kr.co.e1.workreport.main.dialog_proje;

import android.os.Bundle;
import android.support.annotation.StringRes;
import kr.co.e1.workreport.main.dialog_proje.vo.Project;

/**
 * Created by jaeho on 2017. 10. 29
 */

public interface ProjectDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState);

  void onDetach();

  void onPositiveClick();

  interface View {

    void setRecyclerView();

    void refresh();

    void dismiss(Project selectableItem);

    void showProgress();

    void hideProgress();

    void showMessage(@StringRes int resId);
  }
}