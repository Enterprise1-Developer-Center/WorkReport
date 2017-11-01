package kr.co.e1.workreport.teamreportdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 11. 1
 */
public class TeamReportDialog extends BaseAlertDialogFragment
    implements TeamReportDialogPresenter.View {
  @BindView(R.id.save_button) ImageView saveButton;

  @Override protected boolean isNegativeButton() {
    return false;
  }

  @Override protected boolean isPositiveButton() {
    return true;
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Inject TeamReportDialogPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    Timber.d("presenter = " + presenter);
    saveButton.setVisibility(View.GONE);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return R.layout.fragment_report;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.empty_text;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return null;
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return null;
  }
}
