package kr.co.e1.workreport.framework;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by jaeho on 2017. 10. 24
 */

public abstract class BaseAlertDialogFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    return new AlertDialog.Builder(getActivity()).setTitle(getTitle())
        .setPositiveButton(android.R.string.ok, getOkOnClickListener())
        .setNegativeButton(android.R.string.cancel, getCancelOnClickListener())
        .setCancelable(isDialogCancelable())
        .setView(getContentView())
        .create();
  }

  private View getContentView() {
    View view =
        LayoutInflater.from(getContext()).inflate(getLayoutRes(), getRoot(), getAttatchRoot());
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onActivityCreate(savedInstanceState);
  }

  protected abstract void onActivityCreate(Bundle savedInstanceState);

  protected abstract boolean getAttatchRoot();

  protected abstract @LayoutRes int getLayoutRes();

  protected abstract ViewGroup getRoot();

  protected abstract boolean isDialogCancelable();

  protected abstract @StringRes int getTitle();

  protected abstract DialogInterface.OnClickListener getOkOnClickListener();

  protected abstract DialogInterface.OnClickListener getCancelOnClickListener();
}
