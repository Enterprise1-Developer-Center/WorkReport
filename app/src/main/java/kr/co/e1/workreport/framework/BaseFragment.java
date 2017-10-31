package kr.co.e1.workreport.framework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 9. 25
 */

public abstract class BaseFragment extends Fragment {
  private Unbinder unbinder;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Timber.d(getClass().getSimpleName() + " onCreateView()");
    return inflater.inflate(getLayoutResID(), container, false);
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onActivityCreate(savedInstanceState);
    Timber.d(getClass().getSimpleName() + " onActivityCreated()");
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
    Timber.d(getClass().getSimpleName() + " onViewCreated()");
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  protected abstract int getLayoutResID();

  protected abstract void onActivityCreate(Bundle savedInstanceState);

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if(isDagger())AndroidSupportInjection.inject(this);
    Timber.d(getClass().getSimpleName() + " onAttach()");
  }

  protected abstract boolean isDagger();

  @Override public void onStart() {
    super.onStart();
    Timber.d(getClass().getSimpleName() + " onStart()");
  }

  @Override public void onResume() {
    super.onResume();
    Timber.d(getClass().getSimpleName() + " onResume()");
  }

  @Override public void onDetach() {
    super.onDetach();
    Timber.d(getClass().getSimpleName() + " onDetach()");
  }

  @Override public void onPause() {
    super.onPause();
    Timber.d(getClass().getSimpleName() + " onPause()");
  }

  @Override public void onStop() {
    super.onStop();
    Timber.d(getClass().getSimpleName() + " onStop()");
  }
}
