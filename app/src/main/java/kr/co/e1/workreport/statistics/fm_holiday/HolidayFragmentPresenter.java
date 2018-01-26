package kr.co.e1.workreport.statistics.fm_holiday;

import android.os.Bundle;
import android.support.annotation.StringRes;
import kr.co.e1.workreport.statistics.fm_holiday.model.Holiday;

/**
 * Created by jaeho on 2018. 1. 12
 */

public interface HolidayFragmentPresenter {

  void onActivityCreate(Bundle args);

  void onDetach();

  void onComplete();

  void onItemClick(Holiday item);

  interface View {

    void setRecyclerView();

    void showMessage(@StringRes int resId);

    void refresh();

    void removeRefresh();

    void showMessage(String msg);

    void showEditHolidayDialog(Holiday item);

    void showProgress();

    void hideProgress();
  }
}
