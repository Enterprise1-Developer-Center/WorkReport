package kr.co.e1.workreport.statistics.fm_holiday.fd_add_holiday;

import android.os.Bundle;
import android.view.View;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 29
 */

public class AddHolidayDialog extends BaseAlertDialogFragment {

  @Override protected boolean isDagger() {
    return false;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {

  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_add_holiday;
  }

  @Override protected int getTitle() {
    return R.string.holiday_add;
  }

  @Override protected boolean isDialogCancelable() {
    return true;
  }

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return new View.OnClickListener() {
      @Override public void onClick(View view) {

      }
    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> dismiss();
  }

  @DebugLog @OnClick(R.id.holiday_edittext) void onHolidayClick() {

  }
  @DebugLog @OnClick(R.id.legal_holiday_edittext) void onLegalHolidayClick() {

  }
}
