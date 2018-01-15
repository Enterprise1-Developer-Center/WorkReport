package kr.co.e1.workreport.framework;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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
import dagger.android.support.AndroidSupportInjection;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 10. 24
 */

public abstract class BaseAlertDialogFragment extends DialogFragment {

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(getTitle());
    if (isPositiveButton()) {
      builder.setPositiveButton(getPositiveButtonText(), null);
    }
    if (isNeutralButton()) {
      builder.setNeutralButton(getNeutraButtonText(), null);
    }
    if (isNegativeButton()) {
      builder.setNegativeButton(getNegativeButtonText(), null);
    }
    builder.setView(getContentView());
    builder.create();
    return builder.create();
  }

  private View getContentView() {
    View view = LayoutInflater.from(getContext())
        .inflate(getLayoutResId(), getInflateRoot(), getAttatchRoot());
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onActivityCreate(savedInstanceState);
  }

  @Override public void onAttach(Context context) {
    if (isDagger()) AndroidSupportInjection.inject(this);
    super.onAttach(context);
  }

  protected abstract boolean isDagger();

  protected AlertDialog alertDialog;
  protected View contentView;

  @Override public void onStart() {
    super.onStart();
    alertDialog = (AlertDialog) getDialog();
    if (alertDialog != null) {
      contentView = alertDialog.findViewById(R.id.root_view);
      setCancelable(isDialogCancelable());
      alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
          .setOnClickListener(onPositiveClickListener());
      alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
          .setOnClickListener(onNegativeClickListener());
    }
  }

  protected abstract void onActivityCreate(Bundle savedInstanceState);

  protected boolean getAttatchRoot() {
    return false;
  }

  protected ViewGroup getInflateRoot() {
    return null;
  }

  protected abstract @LayoutRes int getLayoutResId();

  protected boolean isDialogCancelable() {
    return false;
  }

  protected abstract @StringRes int getTitle();

  protected @StringRes int getNegativeButtonText() {
    return android.R.string.cancel;
  }

  protected @StringRes int getPositiveButtonText() {
    return android.R.string.ok;
  }

  protected @StringRes int getNeutraButtonText() {
    return android.R.string.ok;
  }

  protected View.OnClickListener onNeutraClickListener() {
    return null;
  }

  protected boolean isNeutralButton() {
    return false;
  }

  protected abstract boolean isNegativeButton();

  protected abstract boolean isPositiveButton();

  protected abstract View.OnClickListener onPositiveClickListener();

  protected abstract View.OnClickListener onNegativeClickListener();
}
