package kr.co.e1.workreport.classificationdialog;

import android.os.Bundle;
import android.support.annotation.StringRes;
import kr.co.e1.workreport.classificationdialog.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;

/**
 * Created by jaeho on 2017. 10. 24
 */

public interface ClassificationDialogPresenter {

  void onActivityCreate(Bundle savedInstanceState, String work);

  void setAdapterDataModel(BaseAdapterDataModel<ClassificationCode> adapter);

  interface View {
    void setRecyclerView();

    void refresh();

    void hideProgress();

    void showProgress();

    void showMessage(@StringRes int resId);

    void showWork(String work);
  }
}