package kr.co.e1.workreport.statistics.dialog_create;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;

/**
 * Created by jaeho on 2018. 1. 3
 */

public class CreateDbFragment extends BaseAlertDialogFragment implements CreateDbPresenter.View {
  @Inject CreateDbPresenter presenter;
  @BindView(R.id.number_picker) NumberPicker numberPicker;

  @Override protected boolean isNegativeButton() {
    return true;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate();
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutResId() {
    return R.layout.dialog_create_db;
  }

  @Override protected ViewGroup getInflateRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.create_year_db;
  }

  @Override protected View.OnClickListener onPositiveClickListener() {
    return view -> {

    };
  }

  @Override protected View.OnClickListener onNegativeClickListener() {
    return view -> {
      dismiss();
    };
  }

  @Override public void setYear(int year, int maxYear, int minYear) {
    numberPicker.setWrapSelectorWheel(true);
    numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
    numberPicker.setMinValue(minYear);
    numberPicker.setMaxValue(maxYear);
    numberPicker.setValue(year);
  }
}